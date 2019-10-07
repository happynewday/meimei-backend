package com.mm.backend.dao;

import com.mm.backend.pojo.FavoratePicture;
import com.mm.backend.pojo.PictureAlbum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoratePictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FavoratePicture record);

    int insertSelective(FavoratePicture record);

    FavoratePicture selectByPrimaryKey(Integer id);

    FavoratePicture selectByUidAndCollectId(Integer uid, Integer collectId);

    List<PictureAlbum> getFavoratePictureList(Integer uid);

    int updateByPrimaryKeySelective(FavoratePicture record);

    int updateByPrimaryKey(FavoratePicture record);
}