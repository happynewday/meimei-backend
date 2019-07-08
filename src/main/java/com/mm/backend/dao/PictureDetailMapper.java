package com.mm.backend.dao;

import com.mm.backend.pojo.PictureDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictureDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PictureDetail record);

    int insertSelective(PictureDetail record);

    PictureDetail selectByPrimaryKey(Integer id);

    List<PictureDetail> selectByCollectId(Integer collectId);

    int updateByPrimaryKeySelective(PictureDetail record);

    int updateByPrimaryKey(PictureDetail record);
}