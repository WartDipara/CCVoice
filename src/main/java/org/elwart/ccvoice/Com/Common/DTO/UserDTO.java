package org.elwart.ccvoice.Com.Common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserDTO implements Serializable {
    private String username;
    private String nickname;
    private String password;
    private String email;
}
