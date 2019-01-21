package com.dms.data.consume.commons.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("响应实体")
public class Result<T>{

    @ApiModelProperty(value="响应码")
    private Integer code;
    @ApiModelProperty(value="响应码描述")
    private String message;
    @ApiModelProperty(value="响应内容")
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private Result(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    private Result(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data=data;
    }

    public static Result succcess(){
        return new Result(ResultCode.SUCCESS_CODE,ResultCode.SUCCESS_MESSAGE,null);
    }

    public  static <T> Result succcess(T data){
        return new Result(ResultCode.SUCCESS_CODE,ResultCode.SUCCESS_MESSAGE,data);
    }

    public static Result succcess(Integer code,String message){
        return new Result(code,message,null);
    }

    public static Result error(){
        return new Result(ResultCode.ERROR_CODE,ResultCode.ERROR_MESSAGE);
    }

    public static Result error(Integer code,String message){
        return new Result(code,message);
    }
}
