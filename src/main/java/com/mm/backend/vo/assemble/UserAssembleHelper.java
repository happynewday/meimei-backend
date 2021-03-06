package com.mm.backend.vo.assemble;

import com.mm.backend.enums.UserLevelEnum;
import com.mm.backend.pojo.PictureCollect;
import com.mm.backend.pojo.User;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.UserBackendVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserAssembleHelper
 * @Description TODO
 * @Date 2019/7/8 11:12
 */
public class UserAssembleHelper {
    public static UserBackendVo assembleUserAuthInfo(User user){
        return  UserBackendVo.builder().
                userId(user.getId()).
                uuid(user.getUuid()).
                username(user.getUsername()).
                nickname(user.getNickname()).
                phone(user.getPhone()).
                level(user.getLevel().intValue()).
                levelName(getLevelName(user.getLevel().intValue())).
                createTime(user.getCreateTime()).
                avatar(user.getAvatar()).
                access_token(user.getAccessToken()).
                build();
    }

    private static String getLevelName(Integer level){
        for(UserLevelEnum e: UserLevelEnum.values()) {
            if (level.equals(e.getLevel())) {
                return e.getName();
            }
        }
        return "游客";
    }
}
