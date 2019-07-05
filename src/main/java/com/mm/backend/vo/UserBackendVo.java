package com.mm.backend.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserBackendVo
 * @Description TODO
 * @Date 2019/7/3 16:51
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserBackendVo {
    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "绑定手机号")
    private String phone;

    /**
     * 等级
     */
    @ApiModelProperty(value = "VIP等级，1为普通用户，2为VIP")
    private Integer level;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 标识
     */
    @ApiModelProperty(value = "标识")
    private String access_token;

    /**
     * 标识有效期
     */
    @ApiModelProperty(value = "标识有效期,单位为秒")
    private Integer expired_in;
}
