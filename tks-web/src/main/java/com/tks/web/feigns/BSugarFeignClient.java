package com.tks.web.feigns;

import com.github.pagehelper.PageInfo;
import com.tks.resource.common.entity.BloodSugar.BSugarParam;
import com.tks.resource.common.entity.SnUserBloodsuger;
import com.tks.web.feigns.hystric.DeptFeignHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "tks-db", fallback = DeptFeignHystric.class)
public interface BSugarFeignClient {
    @RequestMapping("/BloodSugar/getBSugarListByCondition")
    PageInfo<SnUserBloodsuger> getBSugarList(@RequestBody BSugarParam bSugarParam);
/*
    @RequestMapping("/BloodSugar/saveOrUpdateTnmInfo")
    BSugarInfo saveOrUpdateTnmInfo(BSugarInfo bSugarInfo);

    @RequestMapping("/BloodSugar/delBloodSugarInfo")
    int delBloodSugarInfo(BSugarInfo bSugarInfo);*/
}
