package org.elwart.ccvoice.Com.Chat.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.elwart.ccvoice.Com.Common.Entity.User;
import org.elwart.ccvoice.Com.Common.DTO.UserUpdateRequestDTO;

@Mapper
public interface UserMapper {
    // 登录检查，username是unique设置，所以可以保证唯一
    @Select("SELECT * FROM users WHERE username = #{username}")
    User selectByUsername(String username);

    @Insert("INSERT INTO users(username, nickname, password, email) VALUES(#{username}, #{nickname}, #{password}, #{email})")
    int Insert(User user);

    int update(UserUpdateRequestDTO userUpdateRequestDTO);
}
