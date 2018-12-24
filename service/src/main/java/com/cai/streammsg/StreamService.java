package com.cai.streammsg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 接收端
 */
@Slf4j
@Component
@EnableBinding(StreamClient.class)//写的定义的接口Stream
public class StreamService {
  /*  @StreamListener("myMessage")//监听队列消息

    public  void getInput(Object object){
        log.info("========getInput======={}",object);
    }*/
  @StreamListener("myMessage")//监听队列消息
  @SendTo("myOutMessage")//当消息消费成功返回同志
  public  String getInput(Object object){
      log.info("========getInput======={}",object);
      return "收到消息";
  }
   @StreamListener("myOutMessage")
    public void getOutput(String object){
        log.info("========getOutput======={}",object);
    }
}
