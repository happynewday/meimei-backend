package com.mm.backend.vo.assemble;

import com.mm.backend.common.StringUtils;
import com.mm.backend.pojo.Actor;
import com.mm.backend.pojo.ActorNew;
import com.mm.backend.pojo.PictureCollect;
import com.mm.backend.vo.ActorDetailBackendVo;
import com.mm.backend.vo.ActorListBackendVo;
import com.mm.backend.vo.PictureListBackendVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ActorAssembleHelper
 * @Description TODO
 * @Date 2019/8/7 17:11
 */
public class ActorAssembleHelper {
    public static List<ActorListBackendVo> assembleActorList(List<Actor> actorList){
        List<ActorListBackendVo> actorListBackendVos = new ArrayList<>();
        for(Actor actor: actorList){
            actorListBackendVos.add(assembleActor(actor));
        }
        return actorListBackendVos;
    }

    public static ActorListBackendVo assembleActor(Actor actor){
        ActorListBackendVo actorVo = ActorListBackendVo.builder().
                actorId(actor.getId()).
                actorName(actor.getAname()).
                avatar(actor.getAvatar()).
                weibo(actor.getWeibo()).
                homepage(actor.getHomepage()).
                weight((float)48).
                height((float)166).
                cup(actor.getCup()).
                build();
        return actorVo;
    }

    public static ActorDetailBackendVo assembleActorDetail(Actor actor){
        ActorDetailBackendVo actorVo = ActorDetailBackendVo.builder().
                actorId(actor.getId()).
                actorName(actor.getAname()).
                avatar(actor.getAvatar()).
                weibo(actor.getWeibo()).
                homepage(actor.getHomepage()).
                weight((float)48).
                height((float)166).
                cup(actor.getCup()).
                build();
        return actorVo;
    }

    public static ActorDetailBackendVo assembleActorDetailNew(ActorNew actor){
        ActorDetailBackendVo actorVo = ActorDetailBackendVo.builder().
                actorId(actor.getId()).
                actorName(actor.getAname()).
                avatar(actor.getAvatar()).
                weibo(actor.getWeibo()).
                homepage(actor.getHomepage()).
                weight(StringUtils.isBlank(actor.getWt())? null : (float)actor.getWt()).
                height(StringUtils.isBlank(actor.getHt())? null : (float)actor.getHt()).
                cup(actor.getCup()).
                build();
        return actorVo;
    }

    public static List<ActorListBackendVo> assembleActorListNew(List<ActorNew> actorList){
        List<ActorListBackendVo> actorListBackendVos = new ArrayList<>();
        for(ActorNew actor: actorList){
            actorListBackendVos.add(assembleActorNew(actor));
        }
        return actorListBackendVos;
    }

    public static ActorListBackendVo assembleActorNew(ActorNew actor){
        ActorListBackendVo actorVo = ActorListBackendVo.builder().
                actorId(actor.getId()).
                actorName(actor.getAname()).
                avatar(actor.getAvatar()).
                weibo(actor.getWeibo()).
                homepage(actor.getHomepage()).
                weight(StringUtils.isBlank(actor.getWt())? null : (float)actor.getWt()).
                height(StringUtils.isBlank(actor.getHt())? null : (float)actor.getHt()).
                cup(actor.getCup()).
                build();
        return actorVo;
    }
}
