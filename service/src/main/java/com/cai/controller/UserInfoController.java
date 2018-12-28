package com.cai.controller;



import com.cai.common.MessageBox;
import com.cai.service.UserInfoService;
import com.cai.streammsg.StreamClient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试类
 */
@RestController
@RequestMapping("/UserInfo")
//todo  设置Cookie可以跨域请求  此注解可以添加到类上 也可以添加到方法上   对单个类下的接口跨域
@CrossOrigin(allowCredentials = "true")
public class UserInfoController {
    //todo spring-cliud-module
    @Autowired
    private UserInfoService userService;
    /**
     * MQ直接操作
     */
    @Autowired
    private AmqpTemplate amqpTemplate;
    /**
     * 通过官方建议的Stream操作队列
     */
    @Autowired
    private StreamClient streamClient;
    @GetMapping("userHello")
    public MessageBox userInfoControllerHello(){
        return MessageBox.build("100","0.0.1 OK");
    }

    @GetMapping("getAll")
    public MessageBox getAll(){
        return MessageBox.build("100","ok",userService.get());
    }

    @GetMapping("getPhone")
    public MessageBox getName(String userPhone){
        return MessageBox.build("100","ok",userService.getName(userPhone));
    }

    /**
     * MQ直接操作
     * @return
     */
    @GetMapping("Mq")
    public MessageBox Mq(){
        amqpTemplate.convertAndSend("MqQueue","MQ"+new Date());
        return MessageBox.build("100","0.0.1 OKMQ");
    }

    /**
     * 通过Stream 操作MQ消息队列
     */
    @GetMapping("/sendMessage")
    public MessageBox streamSendMessage(){
        /**
         * 消息发送
         */
        //streamClient.output().send(MessageBuilder.withPayload("streamClient"+new Date()).build());
        streamClient.input().send(MessageBuilder.withPayload("通过Stream 操作MQ消息队列"+new Date()).build());
        return MessageBox.build("100","通过Stream 操作MQ消息队列");
    }
}
