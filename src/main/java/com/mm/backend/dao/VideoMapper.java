package com.mm.backend.dao;

import com.mm.backend.pojo.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer id);

    List<Video> selectAll();

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
}