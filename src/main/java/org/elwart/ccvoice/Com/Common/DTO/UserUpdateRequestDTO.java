package org.elwart.ccvoice.Com.Common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDTO {
    private String username;
    private String newNickname;
    private String oldPassword;
    private String newPassword;
}
