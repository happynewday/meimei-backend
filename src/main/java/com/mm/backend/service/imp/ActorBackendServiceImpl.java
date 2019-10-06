package com.mm.backend.service.imp;

import com.github.pagehelper.PageHelper;
import com.mm.backend.common.PageInfo;
import com.mm.backend.dao.ActorMapper;
import com.mm.backend.dao.ActorNewMapper;
import com.mm.backend.pojo.Actor;
import com.mm.backend.pojo.ActorNew;
import com.mm.backend.service.ActorBackendService;
import com.mm.backend.vo.ActorDetailBackendVo;
import com.mm.backend.vo.ActorListBackendVo;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.assemble.ActorAssembleHelper;
import com.mm.backend.vo.assemble.PictureAssembleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ActorBackendServiceImpl
 * @Description TODO
 * @Date 2019/8/7 16:09
 */
@Service
public class ActorBackendServiceImpl implements ActorBackendService {
    @Autowired
    private ActorMapper actorMapper;

    @Autowired
    private ActorNewMapper actorNewMapper;

    public PageInfo<ActorListBackendVo> getActorList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Actor> actorList = actorMapper.selectAll();

        PageInfo pageInfo = new PageInfo(actorList);

        List<ActorListBackendVo> actorListVos = ActorAssembleHelper.assembleActorList(actorList);
        pageInfo.setList(actorListVos);
        return pageInfo;
    }

    public ActorDetailBackendVo getActorDetail(Integer actorId){
        ActorNew actor = actorNewMapper.selectByPrimaryKey(actorId);
        return ActorAssembleHelper.assembleActorDetailNew(actor);
    }
}
