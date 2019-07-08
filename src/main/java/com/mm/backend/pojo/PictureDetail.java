package com.mm.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PictureDetail {
    private Integer id;

    private Integer collectId;

    private String url;

    private Integer height;

    private Integer width;

    private String desc;

    private Long createTime;

    private Integer order;
}