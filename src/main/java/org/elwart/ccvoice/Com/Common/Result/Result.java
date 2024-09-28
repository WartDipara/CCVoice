package org.elwart.ccvoice.Com.Common.Result;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回结果
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {
    private Integer errorCode; // 状态码 100-成功，104-失败
    private String errorMsg; // 错误消息
    private T data;// 数据

    public static <T> Result<T> success(){
        Result<T> result = new Result<>();
        result.errorCode=100;
        return result;
    }
    public static <T> Result<T> success(T obj){
        Result<T> result = new Result<T>();
        result.errorCode=100;
        result.data=obj;
        return result;
    }
    public static <T> Result<T> fail(String msg){
        Result<T> result = new Result<>();
        result.errorCode=104;
        result.errorMsg=msg;
        return result;
    }
}
