package com.mm.backend.pojo;

public class FavoratePicture {
    private Integer id;

    private Integer userId;

    private Integer collectId;

    private Long createTime;

    public FavoratePicture(Integer id, Integer userId, Integer collectId, Long createTime) {
        this.id = id;
        this.userId = userId;
        this.collectId = collectId;
        this.createTime = createTime;
    }

    public FavoratePicture() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}