package com.mm.backend.service;

import com.mm.backend.common.PageInfo;
import com.mm.backend.vo.PictureCollectDetailBackendVo;
import com.mm.backend.vo.PictureListBackendVo;

/**
 * @ClassName PictureBackendService
 * @Description TODO
 * @Date 2019/7/5 14:06
 */
public interface PictureBackendService {
    PageInfo<PictureListBackendVo> getPictureCollectList(Integer pageNum, Integer pageSize);

    PictureCollectDetailBackendVo getPictureCollectDetails(Integer collectId) throws Exception;

//    boolean addFavoratePicture(Integer userId, Integer collectId);
}
