package com.mm.backend.pojo;

import java.util.Date;

public class Actor {
    private Integer id;

    private String aname;

    private String avatar;

    private String weibo;

    private Date birth;

    private Byte ht;

    private Byte wt;

    private Byte b;

    private Byte w;

    private Byte h;

    private String cup;

    private String homepage;

    private Long createTime;

    public Actor(Integer id, String aname, String avatar, String weibo, Date birth, Byte ht, Byte wt, Byte b, Byte w, Byte h, String cup, String homepage, Long createTime) {
        this.id = id;
        this.aname = aname;
        this.avatar = avatar;
        this.weibo = weibo;
        this.birth = birth;
        this.ht = ht;
        this.wt = wt;
        this.b = b;
        this.w = w;
        this.h = h;
        this.cup = cup;
        this.homepage = homepage;
        this.createTime = createTime;
    }

    public Actor() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo == null ? null : weibo.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Byte getHt() {
        return ht;
    }

    public void setHt(Byte ht) {
        this.ht = ht;
    }

    public Byte getWt() {
        return wt;
    }

    public void setWt(Byte wt) {
        this.wt = wt;
    }

    public Byte getB() {
        return b;
    }

    public void setB(Byte b) {
        this.b = b;
    }

    public Byte getW() {
        return w;
    }

    public void setW(Byte w) {
        this.w = w;
    }

    public Byte getH() {
        return h;
    }

    public void setH(Byte h) {
        this.h = h;
    }

    public String getCup() {
        return cup;
    }

    public void setCup(String cup) {
        this.cup = cup == null ? null : cup.trim();
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage == null ? null : homepage.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}