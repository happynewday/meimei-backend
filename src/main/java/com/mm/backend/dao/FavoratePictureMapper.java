package com.mm.backend.dao;

import com.mm.backend.pojo.FavoratePicture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavoratePictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FavoratePicture record);

    int insertSelective(FavoratePicture record);

    FavoratePicture selectByPrimaryKey(Integer id);

    FavoratePicture selectByUidAndCollectId(Integer uid, Integer collectId);

    int updateByPrimaryKeySelective(FavoratePicture record);

    int updateByPrimaryKey(FavoratePicture record);
}