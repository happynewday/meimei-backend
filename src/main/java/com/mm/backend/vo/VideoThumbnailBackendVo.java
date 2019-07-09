package com.mm.backend.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName VideoThumbnailBackendVo
 * @Description TODO
 * @Date 2019/7/9 11:29
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoThumbnailBackendVo {
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
