package com.mm.backend.service;

import com.mm.backend.common.PageInfo;
import com.mm.backend.vo.VideoDetailBackendVo;
import com.mm.backend.vo.VideoListBackendVo;

/**
 * @ClassName VideoBackendService
 * @Description TODO
 * @Date 2019/7/9 11:07
 */
public interface VideoBackendService {
    PageInfo<VideoListBackendVo> getVideoList(Integer pageNum, Integer pageSize);

    VideoDetailBackendVo getVideoDetails(Integer videoId) throws Exception;

    boolean addFavorateVideo(Integer userId, Integer videoId);

    boolean removeFavorateVideo(Integer userId, Integer videoId);
}
