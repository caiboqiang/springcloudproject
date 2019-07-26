package com.cai.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign 调用 服务端 USERINFOEUREKADATASERVICE UserInfoEurekaDataService
 */
@FeignClient(name = "ServiceEureka")//服务名字
public interface Feign {
    @GetMapping("/getAll")
    String getF();
    @GetMapping("/getPhone")
    String getP(@RequestParam("userPhone") String userPhone);
}
