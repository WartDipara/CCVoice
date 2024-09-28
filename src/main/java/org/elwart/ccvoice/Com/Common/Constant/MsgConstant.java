package org.elwart.ccvoice.Com.Common.Constant;

public class MsgConstant {
    //user
    public static final String ACCOUNT_ALREADY_EXIST = "账号已存在";
    public static final String REG_ERROR = "注册失败";
    public static final String PASSWORD_INCORRECT_ERROR = "密码错误，请重新检查";
    public static final String EMPTY_LOGIN_ERROR = "账号或密码为空";
    public static final String LACK_REG_INFO_ERROR = "注册信息不完整";
    public static final String UPDATE_ERROR = "更新失败";
    public static final String CHANGE_INFO_EMPTY_ERROR = "不可以将密码或昵称修改为 空密码 或者 空昵称";

    //redis
    public static final String REDIS_INCR_ERROR = "递增因子必须大于0";
    public static final String REDIS_DECR_ERROR = "递减因子必须大于0";
}
