package org.elwart.ccvoice.Com.Common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private String username;
    private String nickname;
    private String password;
    private String email;

    /**
     * 判断是否缺少信息 , 邮箱可以为空，不加入判断
     * @return true 缺少信息 ,false 没缺少信息
     */
    public boolean isLackInfo(){
        return username==null || nickname==null || password==null;
    }
}
