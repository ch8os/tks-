package com.tks.pat.feigns;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tks.pat.feigns.hystric.PatFeignHystric;
import com.tks.resource.common.entity.TPatientInfo;

/**
 * 
 * @author gl
 *
 */
@FeignClient(value = "tks-db", fallback = PatFeignHystric.class)
public interface IPatFeignClient {
	
    @RequestMapping("/pat/getPatInfo")
    List<TPatientInfo> getPatInfo(@RequestBody TPatientInfo tPatientInfo);

    @RequestMapping("/pat/saveOrUpdatePatInfo")
    TPatientInfo saveOrUpdatePatInfo(@RequestBody TPatientInfo tPatientInfo);

}
