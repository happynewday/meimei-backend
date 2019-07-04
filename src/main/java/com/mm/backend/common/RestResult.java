package com.mm.backend.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Maps;
import com.mm.backend.common.ResponseCode;
import com.mm.backend.common.ValueResponse;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T> implements Serializable {

    @ApiModelProperty(value = "返回码")
    private int status;
    @ApiModelProperty(value = "返回消息")
    private String msg;
    @ApiModelProperty(value = "返回具体内容")
    private T data;

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

    public int getStatus(){
        return status;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }

    private static Object verifyData(Object o)
    {
        if (o == null) {
            return Maps.newHashMap();
        }

        if (o instanceof String) {
            return ValueResponse.val(o);
        }

        if (o instanceof Number) {
            return ValueResponse.val(o);
        }

        if (o instanceof Boolean) {
            return ValueResponse.val(o);
        }

        if (o instanceof Date) {
            return ValueResponse.val(o);
        }

        if (o instanceof List) {
            return ValueResponse.val(o);
        }

        return o;
    }

    public static <T> RestResult<T> createByErrorMessage(String msg){
        return new RestResult(ResponseCode.ERROR.getCode(), msg);
    }

    public static <T> RestResult<T> createByErrorCodeMessage(int code, String msg){
        return new RestResult<>(code, msg);
    }

    public static ResponseEntity<RestResult> createReponseByErrorCodeMessage(int errorCode, String errorMessage){
        RestResult restResult = new RestResult(errorCode, errorMessage);
        return new ResponseEntity<>(restResult, restResult.getStandardStatus());
    }

    public static <T> RestResult<T> createBySuccess(){
        return new RestResult(ResponseCode.SUCCESS.getCode());
    }

    public static <T> RestResult<T> createBySuccess(T data){
        return new RestResult<>(ResponseCode.SUCCESS.getCode(), data);
    }


    public static <T> RestResult<T> createByErrorCode(ResponseCode code){
        return  new RestResult<>(code.getCode(), code.getDesc());
    }

    public static <T> RestResult createByErrorCode(int errorCode, T data){
        return  new RestResult<>(errorCode, data);
    }

    public static  <T> RestResult<T> createByError(){
        return new RestResult<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    private HttpStatus getStandardStatus()
    {
        if (HttpStatus.resolve(this.getStatus()) != null)
        {
            return HttpStatus.valueOf(this.getStatus());
        }
        //统一返回 400 标准状态码
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public String toString() {

        return ("status : " + this.getStatus() + "\n") +
                "msg : " + this.getMsg();
    }
}
