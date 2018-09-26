package com.tks.db.web.dept.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tks.db.common.example.BDeptInfoExample;
import com.tks.db.common.mapper.BDeptInfoMapper;
import com.tks.db.web.dept.service.IDeptService;
import com.tks.resource.common.entity.BDeptInfo;
import com.tks.resource.common.utils.UUIDUtils;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/30
 * @Description:
 */
@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private BDeptInfoMapper tDeptInfoMapper;
    @Override
    public PageInfo<BDeptInfo> getDeptInfoByCondition(BDeptInfo tDeptInfo, int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        BDeptInfoExample tDeptInfoExample = new BDeptInfoExample();
        BDeptInfoExample.Criteria criteria = tDeptInfoExample.createCriteria();
        if(!ObjectUtils.isEmpty(tDeptInfo)){
            criteria.andHosCodeEqualTo(tDeptInfo.getHosCode());
            if(!StringUtils.isEmpty(tDeptInfo.getDeptName()))
                criteria.andDeptNameLike(tDeptInfo.getDeptName()+"%");
            if(!StringUtils.isEmpty(tDeptInfo.getEnabled()))
                criteria.andEnabledEqualTo(tDeptInfo.getEnabled());
        }
        List<BDeptInfo> tDeptInfos = tDeptInfoMapper.selectByExample(tDeptInfoExample);
        PageInfo<BDeptInfo> page = new PageInfo<>(tDeptInfos);
        return new PageInfo<>(tDeptInfos);
    }

    @Override
    public BDeptInfo saveOrUpdateDeptInfo(BDeptInfo tDeptInfo) {
       if(StringUtils.isEmpty(tDeptInfo.getId())){
           tDeptInfo.setId(UUIDUtils.getUUID());
           String deptCode = tDeptInfoMapper.getMaxDeptCode(tDeptInfo.getHosCode());
           if(StringUtils.isEmpty(deptCode))
               tDeptInfo.setDeptCode("1001");
           else
               tDeptInfo.setDeptCode(String.valueOf(Integer.valueOf(deptCode)+1));
           tDeptInfo.setCreateTime(new Date());
           tDeptInfoMapper.insert(tDeptInfo);
       }else{
           tDeptInfo.setModifyTime(new Date());
           tDeptInfoMapper.updateByPrimaryKey(tDeptInfo);
       }
        return tDeptInfo;
    }

    @Override
    public int changDeptStateById(BDeptInfo tDeptInfo) {
        tDeptInfo.setModifyTime(new Date());
        tDeptInfo.setEnabled("0".equals(tDeptInfo.getEnabled())?"1":"0");
        return tDeptInfoMapper.updateByPrimaryKey(tDeptInfo);
    }
}
