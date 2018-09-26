package com.tks.doc.feigns;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tks.doc.feigns.hystric.DocFeignHystric;
import com.tks.resource.common.entity.TDoctorInfo;

/**
 * 
 * @author gl
 *
 */
@FeignClient(value = "tks-db", fallback = DocFeignHystric.class)
public interface IDocFeignClient {
	
    @RequestMapping("/doc/getDocInfo")
    List<TDoctorInfo> getDocInfo(@RequestBody TDoctorInfo TDoctorInfo);

    @RequestMapping("/doc/saveOrUpdateDocInfo")
    TDoctorInfo saveOrUpdateDocInfo(@RequestBody TDoctorInfo TDoctorInfo);

}
