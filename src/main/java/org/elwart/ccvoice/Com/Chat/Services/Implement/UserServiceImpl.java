package org.elwart.ccvoice.Com.Chat.Services.Implement;

import org.elwart.ccvoice.Com.Chat.Mapper.UserMapper;
import org.elwart.ccvoice.Com.Chat.Services.UserService;
import org.elwart.ccvoice.Com.Common.CustomException.usersExceptions.PasswordErrorException;
import org.elwart.ccvoice.Com.Common.CustomException.usersExceptions.RegErrorException;
import org.elwart.ccvoice.Com.Common.CustomException.usersExceptions.UpdateErrorException;
import org.elwart.ccvoice.Com.Common.DTO.UserDTO;
import org.elwart.ccvoice.Com.Common.DTO.UserUpdateRequestDTO;
import org.elwart.ccvoice.Com.Common.Encryption.SHA256Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.elwart.ccvoice.Com.Common.Entity.User;

import static org.elwart.ccvoice.Com.Common.Constant.MsgConstant.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param userDTO
     * @return
     */
    @Override
    public User Login(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = SHA256Encode.encode(userDTO.getPassword());
        User returnUser = userMapper.selectByUsername(username);
        int deleteFlag = returnUser.getDeleteFlag();
        if (returnUser.getPassword().equals(password) && deleteFlag == 0) {
            //密码已经被加密了，不需要多余的信息
            returnUser.setPassword(null);
            return returnUser;
        } else {
            throw new PasswordErrorException();
        }
    }

    /**
     *
     * @param userDTO
     * @return
     */
    @Override
    public void Register(UserDTO userDTO) {
        User user = User.builder().username(userDTO.getUsername())
                .nickname(userDTO.getNickname())
                .password(SHA256Encode.encode(userDTO.getPassword()))
                .email(userDTO.getEmail()).build();
        User returnUser=userMapper.selectByUsername(user.getUsername());
        if(returnUser!=null)
            throw new RegErrorException(ACCOUNT_ALREADY_EXIST);
        int result=userMapper.Insert(user);
        if(result<1)
            throw new RegErrorException(REG_ERROR);
    }

    /**
     * 更新个人账号信息
     * @param userUpdateRequestDTO (用户名，新用户名，密码，新密码）
     * @return
     */
    @Override
    public void update(UserUpdateRequestDTO userUpdateRequestDTO) {
        String oldPw= userUpdateRequestDTO.getOldPassword();
        String newPw= userUpdateRequestDTO.getNewPassword();
        String newNk= userUpdateRequestDTO.getNewNickname();
        if(newPw==null || newPw.isEmpty() || newNk==null || newNk.isEmpty()){
            throw new UpdateErrorException(CHANGE_INFO_EMPTY_ERROR);
        }
        User user=userMapper.selectByUsername(userUpdateRequestDTO.getUsername());
        if(user.getPassword().equals(SHA256Encode.encode(oldPw))){
            //密码正确，可以修改
            userUpdateRequestDTO.setNewPassword(SHA256Encode.encode(newPw));
            String oldNk=user.getNickname();
            if(oldNk.equals(newNk))
                userUpdateRequestDTO.setNewNickname(null);
            if(newPw.equals(user.getPassword()))
                userUpdateRequestDTO.setNewPassword(null);
            int result=userMapper.update(userUpdateRequestDTO);
            if(result>0)
                return;
        }
        throw new UpdateErrorException(UPDATE_ERROR);
    }
}
