package com.mm.backend.service.imp;

import com.mm.backend.dao.TagPictureMapper;
import com.mm.backend.service.TagBackendService;
import com.mm.backend.vo.TagListBackendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagBackendServiceImpl implements TagBackendService {
    @Autowired
    private TagPictureMapper tagPictureMapper;

    public TagListBackendVo getTopTags(){
        List<String> tags = tagPictureMapper.selectTopTag();
        TagListBackendVo tagListBackendVo = TagListBackendVo.builder()
                .tags(tags)
                .build();
        return tagListBackendVo;
    }
}
