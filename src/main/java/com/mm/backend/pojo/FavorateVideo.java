package com.mm.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavorateVideo {
    private Integer id;

    private Integer userId;

    private Integer videoId;

    private Long createTime;
}