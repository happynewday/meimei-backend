package com.mm.backend.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName VideoListBackendVo
 * @Description TODO
 * @Date 2019/7/3 22:00
 */

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoListBackendVo {
    /**
     * 图集ID
     */
    @ApiModelProperty(value = "视频ID")
    private Integer id;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "封面图")
    private String cover;

    /**
     * 图集名称
     */
    @ApiModelProperty(value = "视频名称")
    private String name;

    /**
     * 演员Id
     */
    @ApiModelProperty(value = "演员Id")
    private Integer actorId;

    /**
     * 演员
     */
    @ApiModelProperty(value = "演员")
    private String actor;

    /**
     * 演员头像
     */
    @ApiModelProperty(value = "演员头像")
    private String avatar;

    /**
     * 时长
     */
    @ApiModelProperty(value = "时长，秒为单位")
    private Integer duration;

    /**
     * 视频链接
     */
    @ApiModelProperty(value = "视频链接")
    private String link;
}
