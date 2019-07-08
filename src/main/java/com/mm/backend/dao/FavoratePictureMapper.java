package com.mm.backend.dao;

import com.mm.backend.pojo.FavoratePicture;

public interface FavoratePictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FavoratePicture record);

    int insertSelective(FavoratePicture record);

    FavoratePicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FavoratePicture record);

    int updateByPrimaryKey(FavoratePicture record);
}