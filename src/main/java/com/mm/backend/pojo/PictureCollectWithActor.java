package com.mm.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PictureCollectWithActor {
    private Integer id;

    private String collectName;

    private String cover;

    private Integer pictureNumber;

    private String actor;

    private Integer actorId;

    private String actorAvatar;

    private String publisher;

    private Integer publishId;

    private Long publishTime;

    private String category;

    private String source;

    private Long createTime;

    private String tags;

    private String status;
}