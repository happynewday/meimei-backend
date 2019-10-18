package com.mm.backend.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T> implements Serializable {

    @ApiModelProperty(value = "返回码")
    private int status;
    @ApiModelProperty(value = "返回消息")
    private String msg;
    @ApiModelProperty(value = "返回具体内容")
    private T data;

    public RestResult(IResultType resultType){
        this(resultType.getCode(), resultType.getMsg());
    }

    public RestResult(IResultType resultType, T data){
        this(resultType.getCode(), resultType.getMsg(), data);
    }

    public RestResult(int status)
    {
        this.status = status;
    }

    public RestResult(int status,T data){
        this.status = status;
        this.data = data;
    }
    public RestResult(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public RestResult(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }


    public static <T> RestResult<T> createByErrorMessage(String msg){
        return new RestResult(ResponseCode.ERROR.getCode(), msg);
    }

    public static <T> RestResult<T> createByError(){
        return new RestResult(ResponseCode.ERROR);
    }

    public static <T> RestResult<T> createBySuccess(){
        return new RestResult(ResponseCode.SUCCESS.getCode());
    }

    public static <T> RestResult<T> createBySuccess(T data){
        return new RestResult<>(ResponseCode.SUCCESS.getCode(), data);
    }

    @Override
    public String toString() {

        return ("status : " + this.getStatus() + "\n") +
                "msg : " + this.getMsg();
    }
}
