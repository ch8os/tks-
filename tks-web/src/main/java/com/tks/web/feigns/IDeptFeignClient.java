package com.tks.web.feigns;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tks.resource.common.entity.BDeptInfo;
import com.tks.resource.common.entity.dept.DeptParam;
import com.tks.web.feigns.hystric.DeptFeignHystric;
import com.github.pagehelper.PageInfo;

@FeignClient(value = "tks-db", fallback = DeptFeignHystric.class)
public interface IDeptFeignClient {

    @RequestMapping("/dept/getDeptInfoByCondition")
    PageInfo<BDeptInfo> getDeptInfoByCondition(@RequestBody DeptParam deptParam);
    @RequestMapping("/dept/saveOrUpdateDeptInfo")
    BDeptInfo saveOrUpdateDeptInfo(@RequestBody BDeptInfo bDeptInfo);
    @RequestMapping(value = "/dept/changDeptStateById",method = RequestMethod.POST)
    int changDeptStateById(@RequestBody BDeptInfo bDeptInfo);
}
