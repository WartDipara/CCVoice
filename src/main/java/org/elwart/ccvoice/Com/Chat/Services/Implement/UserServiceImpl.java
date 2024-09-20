package org.elwart.ccvoice.Com.Chat.Services.Implement;

import org.elwart.ccvoice.Com.Chat.Mapper.UserMapper;
import org.elwart.ccvoice.Com.Chat.Services.UserService;
import org.elwart.ccvoice.Com.Common.CustomException.PasswordErrorException;
import org.elwart.ccvoice.Com.Common.DTO.UserDTO;
import org.elwart.ccvoice.Com.Common.Encryption.SHA256Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.elwart.ccvoice.Com.Common.Entity.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User Login(UserDTO userDTO){
        String username= userDTO.getUsername();
        String password= SHA256Encode.encode(userDTO.getPassword());
        User returnUser=userMapper.Login(username);
        if(returnUser.getPassword().equals(password)){
            return returnUser;
        }else{
            throw new PasswordErrorException();
        }
    }
}
