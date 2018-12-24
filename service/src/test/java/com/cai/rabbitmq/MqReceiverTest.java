package com.cai.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqReceiverTest {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Test
    public void mqMsg() {
        //amqpTemplate.convertAndSend("myUserInfo","MQ"+new Date());
    }
}