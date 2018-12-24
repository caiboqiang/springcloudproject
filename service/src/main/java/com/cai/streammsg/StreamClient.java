package com.cai.streammsg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Stream 使用
 *
 */
public interface StreamClient {
    /**
     * Input 固定对应的返回值 SubscribableChannel
     */
    @Input("myMessage")
    SubscribableChannel input();
    /**
     * Output 固定对应的返回值 MessageChannel
     */
    @Output("myOutMessage")
    MessageChannel output();
}
