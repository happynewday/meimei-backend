package com.mm.backend.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName VideoDetailBackendVo
 * @Description TODO
 * @Date 2019/7/4 15:36
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoDetailBackendVo {
    /**
     * 视频ID
     */
    @ApiModelProperty(value = "视频ID")
    private Integer id;

    /**
     * 演员ID
     */
    @ApiModelProperty(value = "演员ID")
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
     * 封面
     */
    @ApiModelProperty(value = "封面")
    private String cover;

    /**
     * 图片数量
     */
    @ApiModelProperty(value = "预览图片数量")
    private Integer number;

    /**
     * 图片列表
     */
    @ApiModelProperty(value = "预览图片列表")
    private List<VideoThumbnailBackendVo> pictures;

    /**
     * 视频链接
     */
    @ApiModelProperty(value = "视频链接")
    private String link;

    /**
     * 视频长度
     */
    @ApiModelProperty(value = "视频长度，秒为单位")
    private Integer duration;

    /**
     * 免费视频长度
     */
    @ApiModelProperty(value = "免费视频长度，秒为单位")
    private Integer freeDuration;
}
