package com.mm.backend.dao;

import com.mm.backend.pojo.PictureCollect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictureCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PictureCollect record);

    int insertSelective(PictureCollect record);

    PictureCollect selectByPrimaryKey(Integer id);

    List<PictureCollect> selectAll();

    List<PictureCollect> selectByActorId(Integer actorId);

    int updateByPrimaryKeySelective(PictureCollect record);

    int updateByPrimaryKey(PictureCollect record);
}