package com.tks.web.bloodsugar.service;

import com.github.pagehelper.PageInfo;
import com.tks.resource.common.entity.BloodSugar.BSugarParam;
import com.tks.resource.common.entity.SnUserBloodsuger;

/**
 * @ Purpose:
 * @Author: wangzhi
 * @Date: 2018/9/10
 */

public interface BloodSugarService {

    PageInfo<SnUserBloodsuger> getBSugarList(BSugarParam bSugarParam);

   /* BSugarInfo saveOrUpdateTnmInfo(BSugarInfo bSugarInfo);

    int delBloodSugarInfo(BSugarInfo tTnmInfo);
*/
}
