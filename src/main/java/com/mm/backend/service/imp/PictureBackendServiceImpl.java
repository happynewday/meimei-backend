package com.mm.backend.service.imp;

import com.github.pagehelper.PageHelper;
import com.mm.backend.common.PageInfo;
import com.mm.backend.common.StringUtils;
import com.mm.backend.dao.*;
import com.mm.backend.pojo.*;
import com.mm.backend.service.PictureBackendService;
import com.mm.backend.vo.PictureCollectDetailBackendVo;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.assemble.PictureAssembleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private FavoratePictureMapper favoratePictureMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ActorMapper actorMapper;

    public PageInfo<PictureListBackendVo> getPictureCollectList(Integer actorId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PictureCollectWithActor> pictureList;
        if(null != actorId) {
            pictureList = pictureCollectMapper.selectByActorId(actorId);
        } else {
            pictureList = pictureCollectMapper.selectAll();
        }
        PageInfo pageInfo = new PageInfo(pictureList);

        List<PictureListBackendVo> pictureListVos = PictureAssembleHelper.assemblePictureList(pictureList);
        pageInfo.setList(pictureListVos);
        return pageInfo;
    }

    public PictureCollectDetailBackendVo getPictureCollectDetails(Integer collectId) throws Exception {
        PictureCollect pictureCollect = pictureCollectMapper.selectByPrimaryKey(collectId);
        if(null == pictureCollect){
            throw new Exception("图集不存在");
        }
        List<PictureDetail> pictureDetails = pictureDetailMapper.selectByCollectId(collectId);
        Actor actor;
        if(StringUtils.isNotBlank(pictureCollect.getActorId())) {
            actor = actorMapper.selectByPrimaryKey(pictureCollect.getActorId());
        } else {
            actor = null;
        }
        return PictureAssembleHelper.assemblePictureDetails(pictureCollect, pictureDetails, actor);
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
}
