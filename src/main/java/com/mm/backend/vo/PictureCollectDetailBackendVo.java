package com.mm.backend.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName PictureCollectDetailBackendVo
 * @Description TODO
 * @Date 2019/7/3 21:07
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PictureCollectDetailBackendVo {
    /**
     * 图集ID
     */
    @ApiModelProperty(value = "图集ID")
    private Integer id;

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

    /**
     * 图片数量
     */
    @ApiModelProperty(value = "图片数量")
    private Integer number;

    /**
     * 免费预览图片数量
     */
    @ApiModelProperty(value = "免费预览图片数量")
    private Integer freeNumber;

    /**
     * 图片列表
     */
    @ApiModelProperty(value = "图片列表")
    private String[] pictures;

    /**
     * 演员信息
     */
    @ApiModelProperty(value = "演员信息")
    private ActorDetailBackendVo actorInfo;
}
