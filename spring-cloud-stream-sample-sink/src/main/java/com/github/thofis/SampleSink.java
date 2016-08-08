package com.github.thofis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * Created by tom on 8/2/16.
 */
@Component
@EnableBinding(Sink.class)
public class SampleSink {
    private static Logger logger = LoggerFactory.getLogger(SpringCloudStreamSampleSinkApplication.class);

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void loggerSink(Object payload) {
        logger.info("Received: " + payload);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
