package com.mm.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoratePicture {
    private Integer id;

    private Integer userId;

    private Integer collectId;

    private Long createTime;

}