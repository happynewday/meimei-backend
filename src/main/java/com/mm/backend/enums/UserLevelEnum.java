package com.mm.backend.enums;

/**
 * @Enum UserLevelEnum
 * @Description TODO
 * @Author xujian
 * @Create 2019-10-22 10:48
 **/
public enum UserLevelEnum {
    NORMAL_MEMBER(1,"普通会员"),
    ADVANCED_MEMBER(2,"普通会员"),
    VIP_MEMBER(3,"普通会员");

    private final Integer level;
    private final String name;


    UserLevelEnum(int level,String name){
        this.level = level;
        this.name = name;
    }

    public Integer getLevel(){
        return level;
    }
    public String getName(){
        return name;
    }
}
