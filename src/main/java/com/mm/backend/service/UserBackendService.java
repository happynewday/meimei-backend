package com.mm.backend.service;

import com.mm.backend.vo.UserBackendVo;
import com.mm.backend.vo.UserVipInfoBackendVo;

/**
 * @ClassName UserBackendService
 * @Description TODO
 * @Date 2019/7/8 9:59
 */
public interface UserBackendService {
    UserBackendVo userRegist(String username, String password) throws Exception;

    UserBackendVo login(String username, String password) throws Exception;

    UserVipInfoBackendVo getUserVipInfo(Integer uid);
}
