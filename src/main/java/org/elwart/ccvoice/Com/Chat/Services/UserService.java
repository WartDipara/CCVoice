package org.elwart.ccvoice.Com.Chat.Services;

import org.elwart.ccvoice.Com.Common.DTO.UserDTO;
import org.elwart.ccvoice.Com.Common.Entity.User;

public interface UserService {
    public User Login(UserDTO userDTO);
}
