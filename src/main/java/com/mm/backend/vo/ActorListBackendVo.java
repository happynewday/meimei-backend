package com.mm.backend.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

/**
 * @ClassName ActorListBackendVo
 * @Description TODO
 * @Date 2019/8/7 15:49
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorListBackendVo {
    /**
     * 演员ID
     */
    @ApiModelProperty(value = "演员ID")
    private Integer actorId;

    /**
     * 演员名称
     */
    @ApiModelProperty(value = "演员名称")
    private String actorName;

    /**
     * 演员封面
     */
    @ApiModelProperty(value = "演员封面")
    private String avatar;

    /**
     * 微博
     */
    @ApiModelProperty(value = "微博")
    private String weibo;

    /**
     * 主页
     */
    @ApiModelProperty(value = "主页")
    private String homepage;

    /**
     * 体重
     */
    @ApiModelProperty(value = "体重")
    private Float weight;

    /**
     * 身高
     */
    @ApiModelProperty(value = "身高")
    private Float height;

    /**
     * 胸围
     */
    @ApiModelProperty(value = "胸围")
    private String cup;
}
