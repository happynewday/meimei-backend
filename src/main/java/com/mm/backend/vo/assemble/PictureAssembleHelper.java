package com.mm.backend.vo.assemble;

import com.mm.backend.pojo.PictureCollect;
import com.mm.backend.pojo.PictureDetail;
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
    public static List<PictureListBackendVo> assemblePictureList(List<PictureCollect> pictureCollectList){
        List<PictureListBackendVo> pictureListVos = new ArrayList<>();
        for(PictureCollect pictureCollect: pictureCollectList){
            pictureListVos.add(assemblePicture(pictureCollect));
        }
        return pictureListVos;
    }

    public static PictureListBackendVo assemblePicture(PictureCollect pictureCollect){
        PictureListBackendVo pictureVo = PictureListBackendVo.builder().
                id(pictureCollect.getId()).
                cover(pictureCollect.getCover()).
                number(pictureCollect.getPictureNumber()).
                name(pictureCollect.getCollectName()).
                actor(pictureCollect.getActor()).
                build();
        return pictureVo;
    }

    public static PictureCollectDetailBackendVo assemblePictureDetails(PictureCollect pictureCollect, List<PictureDetail> pictureDetails) {
        List<SinglePictureVo> pictures = new ArrayList<>();
        for(PictureDetail picture: pictureDetails){
            pictures.add(assembleSinglePicture(picture));
        }

        return PictureCollectDetailBackendVo.builder().
                id(pictureCollect.getId()).
                actor(pictureCollect.getActor()).
                number(pictureCollect.getPictureNumber()).
                pictures(pictures).
                build();
    }

    public static SinglePictureVo assembleSinglePicture(PictureDetail picture){
        return  SinglePictureVo.builder().
                id(picture.getId()).
                url(picture.getUrl()).
                height(picture.getHeight()).
                width(picture.getWidth()).
                desc(picture.getDesc()).
                build();
    }
}
