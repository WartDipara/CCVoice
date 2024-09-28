package org.elwart.ccvoice.Com.Chat.Services;

import org.elwart.ccvoice.Com.Common.DTO.UserDTO;
import org.elwart.ccvoice.Com.Common.DTO.UserUpdateRequestDTO;
import org.elwart.ccvoice.Com.Common.Entity.User;

public interface UserService {
    User Login(UserDTO userDTO);
    void Register(UserDTO userDTO);
    void update(UserUpdateRequestDTO userUpdateRequestDTO);
}
