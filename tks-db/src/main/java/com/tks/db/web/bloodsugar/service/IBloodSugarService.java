package com.tks.db.web.bloodsugar.service;


import com.github.pagehelper.PageInfo;
import com.tks.resource.common.entity.SnUserBloodsuger;
import com.tks.resource.common.entity.BloodSugar.BSugarParam;

import java.text.ParseException;

/**
 * @ Purpose:
 * @Package Name: com.tks.db.web.menu.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */

public interface IBloodSugarService {


    PageInfo<SnUserBloodsuger> getBSugarList(BSugarParam bSugarParam) throws ParseException;


}
