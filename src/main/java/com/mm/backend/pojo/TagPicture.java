package com.mm.backend.pojo;

public class TagPicture {
    private Integer id;

    private String tag;

    private Integer pictureId;

    public TagPicture(Integer id, String tag, Integer pictureId) {
        this.id = id;
        this.tag = tag;
        this.pictureId = pictureId;
    }

    public TagPicture() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }
}