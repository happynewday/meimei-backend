package com.mm.backend.service.imp;

import com.github.pagehelper.PageHelper;
import com.mm.backend.common.PageInfo;
import com.mm.backend.dao.PictureCollectMapper;
import com.mm.backend.pojo.PictureCollect;
import com.mm.backend.service.PictureBackendService;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.assemble.PictureAssembleHelper;
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

    @Autowired
    private PictureCollectMapper pictureCollectMapper;

    public PageInfo<PictureListBackendVo> getPictureCollectList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PictureCollect> pictureList = pictureCollectMapper.selectAll();
        PageInfo pageInfo = new PageInfo(pictureList);

        List<PictureListBackendVo> pictureListVos = PictureAssembleHelper.assemblePictureList(pictureList);
        pageInfo.setList(pictureListVos);
        return pageInfo;
    }
}
