package com.cai.client.controller;

import com.cai.common.MessageBox;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 测试类  调用方
 */
@RestController
public class UserInfoController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("getAll")
    public MessageBox getAll(){
        //第一种方式 是一种硬编码
       /* RestTemplate restTemplate = new RestTemplate();
        String data = restTemplate.getForObject("http://localhost:8081/getAll",String.class);
        JSONObject jsonObject = JSONObject.fromObject(data);
        // userInfo.setUserPhone(jsonObject.getJSONObject("userInfo").getString("userPhone"));
        String dataJson = jsonObject.getString("data");*/

        //方式二 choose("服务名字")
       /* ServiceInstance serviceInstance = loadBalancerClient.choose("UserInfo Eureka Data Service");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = String.format("http://%s:%s",host,port+"/getAll");
        RestTemplate restTemplate = new RestTemplate();
        String data = restTemplate.getForObject(url,String.class);
        JSONObject jsonObject = JSONObject.fromObject(data);
        // userInfo.setUserPhone(jsonObject.getJSONObject("userInfo").getString("userPhone"));
        String dataJson = jsonObject.getString("data");*/

        //方式三
        String data = restTemplate.getForObject("http://SERVICEEUREKA/getAll",String.class);
        JSONObject jsonObject = JSONObject.fromObject(data);
        String dataJson = jsonObject.getString("data");
        return MessageBox.build("100","ok Json",dataJson);


    }


}
