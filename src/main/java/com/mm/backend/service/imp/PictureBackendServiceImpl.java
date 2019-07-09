package com.mm.backend.service.imp;

import com.github.pagehelper.PageHelper;
import com.mm.backend.common.PageInfo;
import com.mm.backend.dao.FavoratePictureMapper;
import com.mm.backend.dao.PictureCollectMapper;
import com.mm.backend.dao.PictureDetailMapper;
import com.mm.backend.dao.UserMapper;
import com.mm.backend.interceptor.AuthInterceptor;
import com.mm.backend.pojo.FavoratePicture;
import com.mm.backend.pojo.PictureCollect;
import com.mm.backend.pojo.PictureDetail;
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
    private static final Logger logger =  LoggerFactory.getLogger(AuthInterceptor.class);

    @Autowired
    private PictureCollectMapper pictureCollectMapper;

    @Autowired
    private PictureDetailMapper pictureDetailMapper;

    @Autowired
    private FavoratePictureMapper favoratePictureMapper;

    @Autowired
    private UserMapper userMapper;

    public PageInfo<PictureListBackendVo> getPictureCollectList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PictureCollect> pictureList = pictureCollectMapper.selectAll();
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
        return PictureAssembleHelper.assemblePictureDetails(pictureCollect, pictureDetails);
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
