package com.cai.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 用于接收rabbitmq的消息
 */
@Slf4j
@Component
public class MqReceiver {
    //todo 第一种消息队列需要自己创建
    //todo @RabbitListener(queues = "myUserInfo")
    //todo 当发布程序自动创建消息队列
    @RabbitListener(queuesToDeclare = @Queue("MqUserInfo"))
    public void MqMsg(String message){
      log.info("接收到来自消息中间的信息:{}",message);
    }
}
