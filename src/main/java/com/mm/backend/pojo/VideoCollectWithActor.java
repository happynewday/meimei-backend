package com.mm.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName VideoCollectWithActor
 * @Description TODO
 * @Date 2019/8/29 17:49
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoCollectWithActor {
    private Integer id;

    private String name;

    private Integer duration;

    private String cover;

    private String actor;

    private Integer actorId;

    private String actorAvatar;

    private String link;

    private Long createTime;
}
