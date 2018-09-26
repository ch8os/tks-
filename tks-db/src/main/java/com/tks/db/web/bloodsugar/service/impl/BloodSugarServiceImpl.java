package com.tks.db.web.bloodsugar.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tks.db.common.mapper.SnUserBloodsugerMapper;
import com.tks.db.web.bloodsugar.service.IBloodSugarService;
import com.tks.resource.common.entity.SnUserBloodsuger;
import com.tks.resource.common.entity.BloodSugar.BSugarParam;


/**
 * @ Purpose:
 * @Package Name: com.tks.db.web.menu.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@Service
public class BloodSugarServiceImpl implements IBloodSugarService {

    @Autowired
    SnUserBloodsugerMapper bSugarInfoMapper;

    @Override
    public PageInfo<SnUserBloodsuger> getBSugarList(BSugarParam bSugarParam) throws ParseException {
        PageHelper.startPage(bSugarParam.getPageNum(), bSugarParam.getPageSize());

        Map<String,String> param=new HashMap<>();
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        if(bSugarParam.getOrganInfo()!=null&&bSugarParam.getOrganInfo().getTesttime()!=null){
            String format = sdf1.format(bSugarParam.getOrganInfo().getTesttime());
            param.put("testtime",format);
        }
        if(bSugarParam.getOrganInfo()!=null&&bSugarParam.getOrganInfo().getEndDate()!=null){
            String format = sdf1.format(bSugarParam.getOrganInfo().getEndDate());
            param.put("endDate",format);
        }
        if(bSugarParam.getOrganInfo()!=null) {
            param.put("usercode", bSugarParam.getOrganInfo().getUsercode());
            param.put("devicesn", bSugarParam.getOrganInfo().getDevicesn());
        }
        List<SnUserBloodsuger> tOrganInfoList=bSugarInfoMapper.getBloodSugarCondition(param);
        //List<SnUserBloodsuger> tOrganInfoList = bSugarInfoMapper.selectByExample(bSugarParam);
        return new PageInfo<>(tOrganInfoList);
    }


}
