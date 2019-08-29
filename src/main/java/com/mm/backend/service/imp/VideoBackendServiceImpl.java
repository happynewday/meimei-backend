package com.mm.backend.service.imp;

import com.github.pagehelper.PageHelper;
import com.mm.backend.common.PageInfo;
import com.mm.backend.common.StringUtils;
import com.mm.backend.dao.ActorMapper;
import com.mm.backend.dao.FavorateVideoMapper;
import com.mm.backend.dao.VideoMapper;
import com.mm.backend.dao.VideoThumbmailMapper;
import com.mm.backend.pojo.*;
import com.mm.backend.service.VideoBackendService;
import com.mm.backend.vo.VideoDetailBackendVo;
import com.mm.backend.vo.VideoListBackendVo;
import com.mm.backend.vo.assemble.VideoAssembleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName VideoBackendServiceImpl
 * @Description TODO
 * @Date 2019/7/9 11:07
 */
@Service
public class VideoBackendServiceImpl implements VideoBackendService {
    @Autowired
    VideoMapper videoMapper;

    @Autowired
    VideoThumbmailMapper videoThumbmailMapper;

    @Autowired
    FavorateVideoMapper favorateVideoMapper;

    @Autowired
    ActorMapper actorMapper;

    public PageInfo<VideoListBackendVo> getVideoList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<VideoCollectWithActor> videos = videoMapper.selectAll();
        PageInfo pageInfo = new PageInfo(videos);

        List<VideoListBackendVo> videoListVos = VideoAssembleHelper.assembleVideoList(videos);
        pageInfo.setList(videoListVos);
        return pageInfo;
    }

    public VideoDetailBackendVo getVideoDetails(Integer videoId) throws Exception{
        Video video = videoMapper.selectByPrimaryKey(videoId);
        if(null == video){
            throw new Exception("视频不存在");
        }

        List<VideoThumbmail> videoThumbmails = videoThumbmailMapper.selectByVideoId(videoId);

        Actor actor;
        if(StringUtils.isNotBlank(video.getActorId())){
            actor = actorMapper.selectByPrimaryKey(video.getActorId());
        } else {
            actor = null;
        }
        return VideoAssembleHelper.assembleVideoDetail(video, videoThumbmails, actor);
    }

    public boolean addFavorateVideo(Integer userId, Integer videoId){
       FavorateVideo favorateVideo = favorateVideoMapper.selectByUidAndVideoId(userId, videoId);
       if(null != favorateVideo){
           return true;
       }

       long time = System.currentTimeMillis();
       favorateVideo = FavorateVideo.builder()
               .userId(userId)
               .videoId(videoId)
               .createTime(time)
               .build();
       favorateVideoMapper.insert(favorateVideo);
       return true;
    }

    public boolean removeFavorateVideo(Integer userId, Integer videoId){
        FavorateVideo favorateVideo = favorateVideoMapper.selectByUidAndVideoId(userId, videoId);
        if(null != favorateVideo){
            favorateVideoMapper.deleteByPrimaryKey(favorateVideo.getId());
        }
        return true;
    }
}
