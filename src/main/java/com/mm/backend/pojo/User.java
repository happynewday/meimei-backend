package com.mm.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private String uuid;

    private String username;

    private String nickname;

    private String password;

    private String salt;

    private String accessToken;

    private String refreshToken;

    private Byte level;

    private String avatar;

    private Byte type;

    private String phone;

    private Boolean status;

    private Boolean isDelete;

    private Long createTime;

    private Long updateTime;
}