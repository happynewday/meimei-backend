package com.mm.backend.dao;

import com.mm.backend.pojo.TagPicture;

public interface TagPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagPicture record);

    int insertSelective(TagPicture record);

    TagPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagPicture record);

    int updateByPrimaryKey(TagPicture record);
}