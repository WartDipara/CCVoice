package org.elwart.ccvoice.Com.Chat.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elwart.ccvoice.Com.Chat.Services.UserService;
import org.elwart.ccvoice.Com.Common.CustomException.usersExceptions.PasswordErrorException;
import org.elwart.ccvoice.Com.Common.CustomException.usersExceptions.RegErrorException;
import org.elwart.ccvoice.Com.Common.CustomException.usersExceptions.UpdateErrorException;
import org.elwart.ccvoice.Com.Common.DTO.UserDTO;
import org.elwart.ccvoice.Com.Common.DTO.UserUpdateRequestDTO;
import org.elwart.ccvoice.Com.Common.Entity.User;
import org.elwart.ccvoice.Com.Common.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.elwart.ccvoice.Com.Common.Constant.MsgConstant.*;

/**
 * 用户接口
 * 功能： 登录、注册、更新个人信息
 */
@RestController
@Slf4j
@CrossOrigin("*")
@Api(tags = "用户接口")
@RequestMapping("/userApi")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 更新个人信息
     *
     * @param userUpdateRequestDTO (username,oldNickname,{newNickname},oldPassword,{newPassword})
     * @return
     * finished
     * time: 2024-09-28
     */
    @ApiOperation(value = "更新个人信息接口")
    @PutMapping
    public Result<String> update(@RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
        try {
            userService.update(userUpdateRequestDTO);
            return Result.success();
        }catch (UpdateErrorException e){
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 用户登录
     *
     * @param userDTO (username,password)
     * @return finished
     * time: 2024-09-28
     */
    @ApiOperation(value = "用户登录接口")
    @PostMapping("/login")
    public Result<User> login(@RequestBody UserDTO userDTO) {
        if (userDTO.getUsername() == null || userDTO.getPassword() == null) {
            return Result.fail(EMPTY_LOGIN_ERROR);
        }
        try {
            User user = userService.Login(userDTO);
            return Result.success(user);
        } catch (PasswordErrorException e) {
            return Result.fail(PASSWORD_INCORRECT_ERROR);
        }
    }

    /**
     * @param userDTO (username,nickname,password,{email}) email为可选
     * @return finished
     * time:
     */
    @ApiOperation(value = "用户注册接口")
    @PostMapping("/reg")
    public Result<String> register(@RequestBody UserDTO userDTO) {
        if (userDTO.isLackInfo()) {
            return Result.fail(LACK_REG_INFO_ERROR);
        }
        try {
            userService.Register(userDTO);
            return Result.success();
        }catch(RegErrorException e){
            return Result.fail(e.getMessage());
        }
    }

    //测试接口能否正常输出
    @ApiOperation(value = "测试接口是否正常")
    @GetMapping("/test")
    public Result<String> test() {
        return Result.success();
    }
}
