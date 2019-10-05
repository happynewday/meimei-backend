package com.mm.backend.vo.assemble;

import com.mm.backend.common.StringUtils;
import com.mm.backend.pojo.*;
import com.mm.backend.vo.PictureCollectDetailBackendVo;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.SinglePictureVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PictureAssembleHelper
 * @Description TODO
 * @Date 2019/7/5 14:31
 */
public class PictureAssembleHelper {
    public static List<PictureListBackendVo> assemblePictureList(List<PictureCollectWithActor> pictureCollectList){
        List<PictureListBackendVo> pictureListVos = new ArrayList<>();
        for(PictureCollectWithActor pictureCollect: pictureCollectList){
            pictureListVos.add(assemblePicture(pictureCollect));
        }
        return pictureListVos;
    }

    public static PictureListBackendVo assemblePicture(PictureCollectWithActor pictureCollect){
        PictureListBackendVo pictureVo = PictureListBackendVo.builder().
                id(pictureCollect.getId()).
                cover(pictureCollect.getCover()).
                number(pictureCollect.getPictureNumber()).
                freeNumber(6).
                name(pictureCollect.getCollectName()).
                actor(pictureCollect.getActor()).
                actorId(pictureCollect.getActorId()).
                avatar(pictureCollect.getActorAvatar()).
                build();
        return pictureVo;
    }

    public static PictureListBackendVo assemblePictureNew(PictureAlbum pictureAlbum){
        PictureListBackendVo pictureVo = PictureListBackendVo.builder().
                id(pictureAlbum.getId()).
                cover(pictureAlbum.getCover()).
                number(pictureAlbum.getPictureNumber()).
                freeNumber(6).
                name(pictureAlbum.getCollectName()).
                actor(pictureAlbum.getActor()).
                actorId(pictureAlbum.getActorId()).
                build();
        return pictureVo;
    }

    public static PictureCollectDetailBackendVo assemblePictureDetails(PictureCollect pictureCollect, List<PictureDetail> pictureDetails, Actor actor) {
        List<SinglePictureVo> pictures = new ArrayList<>();
        for(PictureDetail picture: pictureDetails){
            pictures.add(assembleSinglePicture(picture));
        }

        return PictureCollectDetailBackendVo.builder().
                id(pictureCollect.getId()).
                actor(pictureCollect.getActor()).
                actorId(pictureCollect.getActorId()).
                avatar(null == actor ? "" : actor.getAvatar()).
                number(pictureCollect.getPictureNumber()).
                freeNumber(6).
                build();
    }

    public static PictureCollectDetailBackendVo assemblePictureDetailsNew(PictureAlbum pictureAlbum) {
        String[] pictures = new String[0];
        if(StringUtils.isNotBlank(pictureAlbum.getImgs())) {
            pictures = pictureAlbum.getImgs().split(",");
        }

        return PictureCollectDetailBackendVo.builder().
                id(pictureAlbum.getId()).
                actor(pictureAlbum.getActor()).
                actorId(pictureAlbum.getActorId()).
                number(pictureAlbum.getPictureNumber()).
                freeNumber(6).
                pictures(pictures).
                build();
    }

    public static SinglePictureVo assembleSinglePicture(PictureDetail picture){
        return  SinglePictureVo.builder().
                id(picture.getId()).
                url(picture.getUrl()).
                height(picture.getHeight()).
                width(picture.getWidth()).
                desc(picture.getDescription()).
                build();
    }
}
