package com.mm.backend.vo.assemble;

import com.mm.backend.pojo.*;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.VideoDetailBackendVo;
import com.mm.backend.vo.VideoListBackendVo;
import com.mm.backend.vo.VideoThumbnailBackendVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName VideoAssembleHelper
 * @Description TODO
 * @Date 2019/7/9 11:15
 */
public class VideoAssembleHelper {
    public static List<VideoListBackendVo> assembleVideoList(List<VideoCollectWithActor> videoList){
        List<VideoListBackendVo> videoListVos = new ArrayList<>();
        for(VideoCollectWithActor video: videoList){
            videoListVos.add(assembleVideo(video));
        }
        return videoListVos;
    }

    public static VideoListBackendVo assembleVideo(VideoCollectWithActor video){
        return  VideoListBackendVo.builder()
                .id(video.getId())
                .cover(video.getCover())
                .name(video.getName())
                .actorId(video.getActorId())
                .actor(video.getActor())
                .avatar(video.getActorAvatar())
                .duration(video.getDuration())
                .link(video.getLink())
                .build();
    }

    public static VideoDetailBackendVo assembleVideoDetail(Video video, List<VideoThumbmail> videoThumbmails, Actor actor){
        List<VideoThumbnailBackendVo> videoThumbnailBackendVos = new ArrayList<>();
        for(VideoThumbmail videoThumbmail: videoThumbmails){
            videoThumbnailBackendVos.add(assembleVideoThumbnail(videoThumbmail));
        }

        return VideoDetailBackendVo.builder()
                .id(video.getId())
                .actorId(video.getActorId())
                .actor(video.getActor())
                .avatar(null == actor ? "" : actor.getAvatar())
                .cover(video.getCover())
                .number(videoThumbmails.size())
                .pictures(videoThumbnailBackendVos)
                .link(video.getLink())
                .duration(video.getDuration())
                .freeDuration(30)
                .build();
    }

    public static VideoThumbnailBackendVo assembleVideoThumbnail(VideoThumbmail videoThumbmail){
        return VideoThumbnailBackendVo.builder()
                .id(videoThumbmail.getId())
                .url(videoThumbmail.getLink())
                .height(videoThumbmail.getHeight())
                .width(videoThumbmail.getWidth())
                .desc(videoThumbmail.getDescription())
                .build();
    }
}
