package com.mm.backend.vo.assemble;

import com.mm.backend.pojo.PictureCollect;
import com.mm.backend.pojo.Video;
import com.mm.backend.pojo.VideoThumbmail;
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
    public static List<VideoListBackendVo> assembleVideoList(List<Video> videoList){
        List<VideoListBackendVo> videoListVos = new ArrayList<>();
        for(Video video: videoList){
            videoListVos.add(assembleVideo(video));
        }
        return videoListVos;
    }

    public static VideoListBackendVo assembleVideo(Video video){
        return  VideoListBackendVo.builder()
                .id(video.getId())
                .cover(video.getCover())
                .name(video.getName())
                .actor(video.getActor())
                .duration(video.getDuration())
                .link(video.getLink())
                .build();
    }

    public static VideoDetailBackendVo assembleVideoDetail(Video video, List<VideoThumbmail> videoThumbmails){
        List<VideoThumbnailBackendVo> videoThumbnailBackendVos = new ArrayList<>();
        for(VideoThumbmail videoThumbmail: videoThumbmails){
            videoThumbnailBackendVos.add(assembleVideoThumbnail(videoThumbmail));
        }

        return VideoDetailBackendVo.builder()
                .id(video.getId())
                .actor(video.getActor())
                .cover(video.getCover())
                .number(videoThumbmails.size())
                .pictures(videoThumbnailBackendVos)
                .link(video.getLink())
                .duration(video.getDuration())
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
