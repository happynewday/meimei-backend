package com.mm.backend.common;

/**
 * @ClassName ResponseCode
 * @Description TODO
 * @Date 2019/7/3 17:04
 */
public enum ResponseCode implements IResultType {

    SUCCESS(0,"SUCCESS"),
    ORDER_REQUEST_PRODUCT_NOT_EXIST(100,"商品不存在"),
    ORDER_REQUEST_ORDER_GENERATE_FAILED(101,"订单生成失败"),

    PREPAY_ORDER_NOT_EXIST(110,"订单不存在"),

    ORDER_NOTIFY_FAILED(120,"订单回调失败"),

    PICTURE_COLLECT_NOT_EXIST(130,"图集不存在"),

    PICTURE_FAVORATE_FAILED(140,"收藏图集失败"),
    PICTURE_UNFAVORATE_FAILED(141,"取消收藏图集失败"),

    USER_REGIST_ACCOUNT_ALREADY_EXIST(150,"用户账号已存在"),
    USER_REGIST_ADD_ACCOUNT_FAILED(151,"添加账号失败"),

    USER_LOGIN_ACCOUNT_OR_PASSWD_WRONG(160,"账号或密码错误"),

    USER_INFO_USER_NOT_EXIST(170,"用户不存在"),

    VIDIO_NOT_EXIST(180,"视频不存在"),

    VIDEO_FAVORATE_FAILED(190,"收藏视频失败"),
    VIDEO_UNFAVORATE_FAILED(191,"取消收藏视频失败"),

    /*
        普通失败
     */
    ERROR(500,"ERROR");

    private final Integer code;
    private final String msg;


    ResponseCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
}
