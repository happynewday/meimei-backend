package com.mm.backend.dao;

import com.mm.backend.pojo.PictureAlbum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictureAlbumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PictureAlbum record);

    int insertSelective(PictureAlbum record);

    PictureAlbum selectByPrimaryKey(Integer id);

    List<PictureAlbum> selectAll();

    List<PictureAlbum> selectByActorId(Integer actorId);

    List<PictureAlbum> selectByTag(String tag);

    int updateByPrimaryKeySelective(PictureAlbum record);

    int updateByPrimaryKeyWithBLOBs(PictureAlbum record);

    int updateByPrimaryKey(PictureAlbum record);
}