package com.mm.backend.service.imp;

import com.github.pagehelper.PageHelper;
import com.mm.backend.common.PageInfo;
import com.mm.backend.common.StringUtils;
import com.mm.backend.dao.*;
import com.mm.backend.exceptions.BusinessException;
import com.mm.backend.pojo.*;
import com.mm.backend.service.ActorBackendService;
import com.mm.backend.service.PictureBackendService;
import com.mm.backend.vo.PictureCollectDetailBackendVo;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.assemble.PictureAssembleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mm.backend.common.ResponseCode.PICTURE_COLLECT_NOT_EXIST;

/**
 * @ClassName PictureBackendServiceImpl
 * @Description TODO
 * @Date 2019/7/5 14:08
 */
@Service
public class PictureBackendServiceImpl implements PictureBackendService {
    private static final Logger logger =  LoggerFactory.getLogger(PictureBackendServiceImpl.class);

    @Autowired
    private PictureCollectMapper pictureCollectMapper;

    @Autowired
    private PictureDetailMapper pictureDetailMapper;

    @Autowired
    private PictureAlbumMapper pictureAlbumMapper;

    @Autowired
    private FavoratePictureMapper favoratePictureMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ActorMapper actorMapper;

    @Autowired
    private ActorBackendService actorBackendService;

    public PageInfo<PictureListBackendVo> getPictureCollectList(Integer actorId, String tag, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        //List<PictureCollectWithActor> pictureList;
        List<PictureAlbum> pictureList;
        if(null != actorId) {
            pictureList = pictureAlbumMapper.selectByActorId(actorId);
        } else if (StringUtils.isNotBlank(tag)){
            pictureList = pictureAlbumMapper.selectByTag(tag);
        } else {
            pictureList = pictureAlbumMapper.selectAll();
        }
        formatPictureUrlList(pictureList);
        PageInfo pageInfo = new PageInfo(pictureList);

        pageInfo.setList(AssemblePictureList(pictureList));
        return pageInfo;
    }

    public PictureCollectDetailBackendVo getPictureCollectDetails(Integer collectId) throws BusinessException {
        PictureAlbum pictureAlbum = pictureAlbumMapper.selectByPrimaryKey(collectId);
        if(null == pictureAlbum){
            throw new BusinessException(PICTURE_COLLECT_NOT_EXIST);
        }
        formatPictureUrl(pictureAlbum);
        PictureCollectDetailBackendVo pictureCollectDetailBackendVo = PictureAssembleHelper.assemblePictureDetailsNew(pictureAlbum);
        if(StringUtils.isNotBlank(pictureAlbum.getActorId())) {
            pictureCollectDetailBackendVo.setActorInfo(actorBackendService.getActorDetail(pictureAlbum.getActorId()));
        } else {
            pictureCollectDetailBackendVo.setActorInfo(null);
        }

        return pictureCollectDetailBackendVo;
    }

    public boolean addFavoratePicture(Integer userId, Integer collectId){
        FavoratePicture favoratePicture = favoratePictureMapper.selectByUidAndCollectId(userId, collectId);
        if(null != favoratePicture){
            return true;
        }

        long time = System.currentTimeMillis();
        favoratePicture = FavoratePicture.builder()
                .userId(userId)
                .collectId(collectId)
                .createTime(time)
                .build();
        favoratePictureMapper.insert(favoratePicture);
        return true;
    }

    public boolean removeFavoratePicture(Integer userId, Integer collectId){
        FavoratePicture favoratePicture = favoratePictureMapper.selectByUidAndCollectId(userId, collectId);
        if(null != favoratePicture){
            favoratePictureMapper.deleteByPrimaryKey(favoratePicture.getId());
        }
        return true;
    }

    public PageInfo<PictureListBackendVo> getFavorateList(Integer userId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);

        List<PictureAlbum> pictureList = favoratePictureMapper.getFavoratePictureList(userId);
        PageInfo pageInfo = new PageInfo(pictureList);

        pageInfo.setList(AssemblePictureList(pictureList));
        return pageInfo;
    }

    private List<PictureListBackendVo> AssemblePictureList(List<PictureAlbum> pictureList){
        List<PictureListBackendVo> pictureListVos = new ArrayList<>();
        for(PictureAlbum picture: pictureList){
            PictureListBackendVo pictureVo = PictureAssembleHelper.assemblePictureNew(picture);
            if(StringUtils.isNotBlank(picture.getActorId())) {
                pictureVo.setActorInfo(actorBackendService.getActorDetail(picture.getActorId()));
            } else {
                pictureVo.setActorInfo(null);
            }
            pictureListVos.add(pictureVo);
        }
        return pictureListVos;
    }

    private void formatPictureUrl(PictureAlbum picture){
        if(StringUtils.isNotBlank(picture.getSourceImgs())) {
            picture.setSourceImgs(picture.getSourceImgs().replaceAll("http://picture-cors.iojkj.cn/a/1/", "http://mm.iojkj.cn/images/"));
        }
        if(StringUtils.isNotBlank(picture.getCover())){
            picture.setCover(picture.getCover().replaceAll("http://picture-cors.iojkj.cn/a/1/", "http://mm.iojkj.cn/images/"));
        }
    }

    private void formatPictureUrlList(List<PictureAlbum> pictures){
        for(PictureAlbum picture: pictures){
            formatPictureUrl(picture);
        }
    }
}
