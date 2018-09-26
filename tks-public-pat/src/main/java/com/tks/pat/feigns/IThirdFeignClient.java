package com.tks.pat.feigns;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tks.pat.feigns.hystric.UserFeignHystric;

@FeignClient(value = "tks-third-interface", fallback = UserFeignHystric.class)
public interface IThirdFeignClient {
	 /**
     * 获取用户长令牌
     *
     * @param userKey
     * @return
     */
    @RequestMapping("/wbs/singleSend")
    String singleSend(@RequestParam(value = "mobile") String mobile);
}
