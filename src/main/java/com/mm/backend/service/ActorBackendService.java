package com.mm.backend.service;

import com.mm.backend.common.PageInfo;
import com.mm.backend.vo.ActorDetailBackendVo;
import com.mm.backend.vo.ActorListBackendVo;
import com.mm.backend.vo.PictureListBackendVo;

/**
 * @ClassName ActorBackendService
 * @Description TODO
 * @Date 2019/8/7 16:08
 */
public interface ActorBackendService {
    PageInfo<ActorListBackendVo> getActorList(Integer pageNum, Integer pageSize);

    ActorDetailBackendVo getActorDetail(Integer actorId);
}
