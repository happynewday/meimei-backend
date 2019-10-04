package com.mm.backend.pojo;

public class DistinctTag {
    private String tag;

    public DistinctTag(String tag) {
        this.tag = tag;
    }

    public DistinctTag() {
        super();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}