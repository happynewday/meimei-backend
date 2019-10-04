package com.mm.backend.dao;

import com.mm.backend.pojo.DistinctTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DistinctTagMapper {
    int insert(DistinctTag record);

    int insertSelective(DistinctTag record);

    List<DistinctTag> selectAll();
}