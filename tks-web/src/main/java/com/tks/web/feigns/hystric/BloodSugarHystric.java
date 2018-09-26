package com.tks.web.feigns.hystric;

import com.github.pagehelper.PageInfo;
import com.tks.resource.common.entity.BloodSugar.BSugarParam;
import com.tks.resource.common.entity.SnUserBloodsuger;
import com.tks.web.feigns.BSugarFeignClient;

public class BloodSugarHystric implements BSugarFeignClient {

    @Override
    public PageInfo<SnUserBloodsuger> getBSugarList(BSugarParam bSugarParam) {
        return null;
    }

  /*  @Override
    public BSugarInfo saveOrUpdateTnmInfo(BSugarInfo bSugarInfo) {
        return null;
    }

    @Override
    public int delBloodSugarInfo(BSugarInfo bSugarInfo) {
        return 0;
    }
*/

}
