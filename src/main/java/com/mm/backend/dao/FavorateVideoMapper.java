package com.mm.backend.dao;

import com.mm.backend.pojo.FavorateVideo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavorateVideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FavorateVideo record);

    int insertSelective(FavorateVideo record);

    FavorateVideo selectByPrimaryKey(Integer id);

    FavorateVideo selectByUidAndVideoId(Integer uid, Integer videoId);

    int updateByPrimaryKeySelective(FavorateVideo record);

    int updateByPrimaryKey(FavorateVideo record);
}