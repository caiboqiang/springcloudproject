package com.cai.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 用于接收rabbitmq的消息 相当于去消息队列拉去消息
 */
@Slf4j
@Component
public class MqReceiver {
    //todo 第一种消息队列需要自己创建
    //todo @RabbitListener(queues = "myUserInfo")
    /*public void MqMsg(String message){
        log.info("接收到来自消息中间的信息:{}",message);*/
    //todo 当发布程序自动创建消息队列
    //todo @RabbitListener(queuesToDeclare = @Queue("MqUserInfo"))
       /* public void MqMsg(String message){
            log.info("接收到来自消息中间的信息:{}",message);*/
    //todo Exchenge和Queu绑定
    @RabbitListener(bindings = @QueueBinding(value = @Queue("MqQueue"),exchange = @Exchange("MqExchange")))
    public void MqMsg(String message){
      log.info("接收到来自消息中间的信息:{}",message);
    }
}
