package com.mm.backend.pojo;

public class VideoThumbmail {
    private Integer id;

    private Integer videoId;

    private String link;

    private Integer height;

    private Integer width;

    private String desc;

    private Long createTime;

    private Integer order;

    public VideoThumbmail(Integer id, Integer videoId, String link, Integer height, Integer width, String desc, Long createTime, Integer order) {
        this.id = id;
        this.videoId = videoId;
        this.link = link;
        this.height = height;
        this.width = width;
        this.desc = desc;
        this.createTime = createTime;
        this.order = order;
    }

    public VideoThumbmail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}