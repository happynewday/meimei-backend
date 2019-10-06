package com.mm.backend.dao;

import com.mm.backend.pojo.Actor;
import com.mm.backend.pojo.ActorNew;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActorNewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActorNew record);

    int insertSelective(ActorNew record);

    ActorNew selectByPrimaryKey(Integer id);

    List<ActorNew> selectAll();

    int updateByPrimaryKeySelective(ActorNew record);

    int updateByPrimaryKey(ActorNew record);
}