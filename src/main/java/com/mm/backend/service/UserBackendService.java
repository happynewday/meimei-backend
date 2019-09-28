package com.mm.backend.service;

import com.mm.backend.vo.UserBackendVo;

/**
 * @ClassName UserBackendService
 * @Description TODO
 * @Date 2019/7/8 9:59
 */
public interface UserBackendService {
    UserBackendVo userRegist(String uuid, String username, String password) throws Exception;

    UserBackendVo login(String username, String password, String uuid) throws Exception;

    UserBackendVo getUserInfo(Integer uid, String uuid) throws RuntimeException;
}
