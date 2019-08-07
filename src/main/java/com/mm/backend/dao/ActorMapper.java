package com.mm.backend.dao;

import com.mm.backend.pojo.Actor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Actor record);

    int insertSelective(Actor record);

    Actor selectByPrimaryKey(Integer id);

    List<Actor> selectAll();

    int updateByPrimaryKeySelective(Actor record);

    int updateByPrimaryKey(Actor record);
}