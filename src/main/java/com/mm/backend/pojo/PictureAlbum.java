package com.mm.backend.pojo;

public class PictureAlbum {
    private Integer id;

    private String collectName;

    private String cover;

    private Integer pictureNumber;

    private String actor;

    private Integer actorId;

    private String publisher;

    private Integer publishId;

    private Long publishTime;

    private String category;

    private String source;

    private Long createTime;

    private String freeImgs;

    private String sourceImgs;

    private String tags;

    private String status;

    private String imgs;

    public PictureAlbum(Integer id, String collectName, String cover, Integer pictureNumber, String actor, Integer actorId, String publisher, Integer publishId, Long publishTime, String category, String source, Long createTime, String freeImgs, String sourceImgs, String tags, String status, String imgs) {
        this.id = id;
        this.collectName = collectName;
        this.cover = cover;
        this.pictureNumber = pictureNumber;
        this.actor = actor;
        this.actorId = actorId;
        this.publisher = publisher;
        this.publishId = publishId;
        this.publishTime = publishTime;
        this.category = category;
        this.source = source;
        this.createTime = createTime;
        this.freeImgs = freeImgs;
        this.sourceImgs = sourceImgs;
        this.tags = tags;
        this.status = status;
        this.imgs = imgs;
    }

    public PictureAlbum() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollectName() {
        return collectName;
    }

    public void setCollectName(String collectName) {
        this.collectName = collectName == null ? null : collectName.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public Integer getPictureNumber() {
        return pictureNumber;
    }

    public void setPictureNumber(Integer pictureNumber) {
        this.pictureNumber = pictureNumber;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor == null ? null : actor.trim();
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getFreeImgs() {
        return freeImgs;
    }

    public void setFreeImgs(String freeImgs) {
        this.freeImgs = freeImgs == null ? null : freeImgs.trim();
    }

    public String getSourceImgs() {
        return sourceImgs;
    }

    public void setSourceImgs(String sourceImgs) {
        this.sourceImgs = sourceImgs == null ? null : sourceImgs.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }
}