package com.mm.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    private Integer id;

    private String name;

    private Integer duration;

    private String cover;

    private String actor;

    private Integer actorId;

    private String link;

    private Long createTime;
}