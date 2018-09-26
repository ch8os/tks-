package com.tks.web.bloodsugar.service.impl;

import com.github.pagehelper.PageInfo;
import com.tks.resource.common.entity.*;
import com.tks.resource.common.entity.BloodSugar.BSugarParam;
import com.tks.web.bloodsugar.service.BloodSugarService;
import com.tks.web.feigns.BSugarFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ Purpose:
 * @Package Name: com.tks.db.web.menu.service.impl
 * @Author: wangzhi
 * @Date: 2018/9/10
 */
@Service
public class BloodSugarServiceImpl implements BloodSugarService {

    @Autowired
    BSugarFeignClient bSugarFeignClient;


    @Override
    public PageInfo<SnUserBloodsuger> getBSugarList(BSugarParam bSugarParam) {
        return bSugarFeignClient.getBSugarList(bSugarParam);
    }

    /*@Override
    public BSugarInfo saveOrUpdateTnmInfo(BSugarInfo bSugarInfo) {
        return bSugarFeignClient.saveOrUpdateTnmInfo(bSugarInfo);
    }

    @Override
    public int delBloodSugarInfo(BSugarInfo bSugarInfo) {
        return bSugarFeignClient.delBloodSugarInfo(bSugarInfo);
    }*/
}
