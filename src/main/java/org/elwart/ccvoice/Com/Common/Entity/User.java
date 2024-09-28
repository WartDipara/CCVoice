package org.elwart.ccvoice.Com.Common.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String username; // 用户名，不建议修改
    private String nickname; // 昵称，可修改
    private String password; // 密码
    private String email;    // 邮箱
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime; // 更新时间默认与创建时间一致
    private byte deleteFlag; // 0-未删除，1-已删除
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deleteTime; // 删除时间默认为null
}
