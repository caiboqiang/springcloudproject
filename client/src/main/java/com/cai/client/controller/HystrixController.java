package com.cai.client.controller;

import com.cai.common.MessageBox;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")//默认所有方法提供这个服务降级方法
public class HystrixController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 出发服务降级
     * @return 语言
     */
    // @HystrixCommand(fallbackMethod = "fallback") //todo fallbackMethod = "方法名"

    //@HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")}) //@HystrixProperty(name = "default_executionTimeoutInMilliseconds",value = "3000")设置请求超时时间
    //todo 服务熔断
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"),//请求超时
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//设置熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//断路器的最小请求数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//错误率
    })
    //@HystrixCommand
    @GetMapping("/gets")
    public MessageBox getNames(){
        String data = restTemplate.getForObject("http://SERVICEEUREKA/getAll",String.class);
        JSONObject jsonObject = JSONObject.fromObject(data);
        String dataJson = jsonObject.getString("data");
        return MessageBox.build("100","ok Json",dataJson);
    }

    /**
     * 当服务挂掉 或者请求失败 进入此方法
     * @return
     */
    private MessageBox fallback(){
        return  MessageBox.build("100","ok Json","今天不上班“滚！！！！！！！！！！！”");

    }
    private MessageBox defaultFallback(){
        return  MessageBox.build("100","ok Json","服务降级。今天不上班“滚！！！！！！！！！！！”");

    }

}
