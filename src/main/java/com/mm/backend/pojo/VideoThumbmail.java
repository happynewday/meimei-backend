package com.mm.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoThumbmail {
    private Integer id;

    private Integer videoId;

    private String link;

    private Integer height;

    private Integer width;

    private String description;

    private Long createTime;

    private Integer order;
}