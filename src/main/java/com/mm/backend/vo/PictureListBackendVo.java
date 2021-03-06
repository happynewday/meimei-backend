package com.mm.backend.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName PictureListBackendVo
 * @Description TODO
 * @Date 2019/7/3 21:00
 */

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PictureListBackendVo {
    /**
     * 图集ID
     */
    @ApiModelProperty(value = "图集ID")
    private Integer id;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "封面图")
    private String cover;

    /**
     * 图片数量
     */
    @ApiModelProperty(value = "图集中图片数量")
    private Integer number;

    /**
     * 免费预览图片数量
     */
    @ApiModelProperty(value = "免费预览图片数量")
    private Integer freeNumber;

    /**
     * 图集名称
     */
    @ApiModelProperty(value = "图集名称")
    private String name;

    /**
     * 演员信息
     */
    @ApiModelProperty(value = "演员信息")
    private ActorDetailBackendVo actorInfo;

    /**
     * 演员
     */
    @ApiModelProperty(value = "演员")
    private String actor;

    /**
     * 演员ID
     */
    @ApiModelProperty(value = "演员ID")
    private Integer actorId;

    /**
     * 演员头像
     */
    @ApiModelProperty(value = "演员头像")
    private String avatar;
}
