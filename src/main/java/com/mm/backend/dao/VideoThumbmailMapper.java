package com.mm.backend.dao;

import com.mm.backend.pojo.VideoThumbmail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoThumbmailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoThumbmail record);

    int insertSelective(VideoThumbmail record);

    VideoThumbmail selectByPrimaryKey(Integer id);

    List<VideoThumbmail> selectByVideoId(Integer videoId);

    int updateByPrimaryKeySelective(VideoThumbmail record);

    int updateByPrimaryKey(VideoThumbmail record);
}