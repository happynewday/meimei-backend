package com.mm.backend.common;

/**
 * @ClassName ResponseCode
 * @Description TODO
 * @Author XUJIAN
 * @Date 2019/7/3 17:04
 */
public enum ResponseCode {

    /*
        请求成功
     */
    SUCCESS(200,"SUCCESS"),

    /*
        普通失败
     */
    ERROR(500,"ERROR");

    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}
