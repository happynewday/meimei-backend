package com.mm.backend.service;

import com.mm.backend.exceptions.BusinessException;
import com.mm.backend.vo.UserBackendVo;

/**
 * @ClassName UserBackendService
 * @Description TODO
 * @Date 2019/7/8 9:59
 */
public interface UserBackendService {
    UserBackendVo userRegist(String uuid, String username, String password) throws BusinessException;

    UserBackendVo login(String username, String password, String uuid) throws BusinessException;

    UserBackendVo getUserInfo(Integer uid, String uuid) throws BusinessException;

    boolean setVIPLevel(Integer uid, Byte level);

    void changePasswd(Integer uid, String passwd)  throws BusinessException;
}
