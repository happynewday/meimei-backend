package com.mm.backend.service;

import com.mm.backend.vo.UserBackendVo;

/**
 * @ClassName UserBackendService
 * @Description TODO
 * @Date 2019/7/8 9:59
 */
public interface UserBackendService {
    UserBackendVo userRegist(String username, String password) throws Exception;
}
