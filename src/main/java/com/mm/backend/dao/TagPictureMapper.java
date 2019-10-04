package com.mm.backend.dao;

import com.mm.backend.pojo.TagPicture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagPicture record);

    int insertSelective(TagPicture record);

    TagPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagPicture record);

    int updateByPrimaryKey(TagPicture record);
}