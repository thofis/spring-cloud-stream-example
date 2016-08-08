package com.github.thofis;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by tom on 8/5/16.
 */
public interface MySource {

    String CHANNEL_NAME = "myOutput";

    @Output(CHANNEL_NAME)
    MessageChannel output();

}
