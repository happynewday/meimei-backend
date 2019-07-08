package com.mm.backend.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName SinglePictureVo
 * @Description TODO
 * @Date 2019/7/5 16:40
 */

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SinglePictureVo {
    /**
     * 图片ID
     */
    @ApiModelProperty(value = "图片ID")
    private Integer id;

    /**
     * 图片链接
     */
    @ApiModelProperty(value = "图片链接")
    private String url;

    /**
     * 图片高度
     */
    @ApiModelProperty(value = "图片高度")
    private Integer height;

    /**
     * 图片宽度
     */
    @ApiModelProperty(value = "图片宽度")
    private Integer width;

    /**
     * 图片描述
     */
    @ApiModelProperty(value = "图片描述")
    private String desc;
}
