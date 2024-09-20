package org.elwart.ccvoice.Com.Chat.Mapper;

import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.elwart.ccvoice.Com.Common.Entity.User;

@Mapper
public interface UserMapper {
    // 登录检查，username是unique设置，所以可以保证唯一
    @Select("SELECT * FROM users WHERE username = #{username}")
    User Login(String username);
}
