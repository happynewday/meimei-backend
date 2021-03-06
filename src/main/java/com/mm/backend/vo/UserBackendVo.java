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
     * 设备ID
     */
    @ApiModelProperty(value = "设备ID")
    private String uuid;

    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名")
    private String username;

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
    @ApiModelProperty(value = "VIP等级，0为普通用户，1为普通会员，2为高级会员，3为VIP")
    private Integer level;

    /**
     * 等级名称
     */
    @ApiModelProperty(value = "用户等级名称")
    private String levelName;

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
     * 标识, 这里用下划线写法是跟前端特别约定，不要改
     */
    @ApiModelProperty(value = "标识")
    private String access_token;

    /**
     * 账户到期时间
     */
    @ApiModelProperty(value = "账户到期时间")
    private String validTime;
}
