package org.elwart.ccvoice.Com.Chat.Controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.elwart.ccvoice.Com.Chat.Services.UserService;
import org.elwart.ccvoice.Com.Common.DTO.UserDTO;
import org.elwart.ccvoice.Com.Common.Entity.User;
import org.elwart.ccvoice.Com.Common.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Api(tags = "用户相关接口")
@Controller
@Slf4j
@CrossOrigin(value="*",exposedHeaders = "*",allowCredentials = "*")
public class UserController {
    @Autowired
    private UserService userService;

    public Result<User> Login(UserDTO userDTO) {
        return Result.success();
    }
}
