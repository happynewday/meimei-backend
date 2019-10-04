package com.mm.backend.service.imp;

import com.mm.backend.dao.DistinctTagMapper;
import com.mm.backend.dao.TagPictureMapper;
import com.mm.backend.pojo.DistinctTag;
import com.mm.backend.service.TagBackendService;
import com.mm.backend.vo.TagListBackendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagBackendServiceImpl implements TagBackendService {
    @Autowired
    private TagPictureMapper tagPictureMapper;

    @Autowired
    private DistinctTagMapper distinctTagMapper;

    public TagListBackendVo getTopTags(){
        List<DistinctTag> tags = distinctTagMapper.selectAll();
        List<String> tagLists = tags.stream().map(i -> i.getTag()).collect(Collectors.toList());
        TagListBackendVo tagListBackendVo = TagListBackendVo.builder()
                .tags(tagLists)
                .build();
        return tagListBackendVo;
    }
}
