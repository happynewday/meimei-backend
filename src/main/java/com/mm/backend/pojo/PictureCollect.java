package com.mm.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PictureCollect {
    private Integer id;

    private String collectName;

    private String cover;

    private Integer pictureNumber;

    private String actor;

    private Long createTime;

    private Boolean isDelete;
}