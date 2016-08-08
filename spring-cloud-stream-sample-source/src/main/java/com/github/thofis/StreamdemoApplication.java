package com.github.thofis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableBinding(MySource.class)
public class StreamdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamdemoApplication.class, args);
    }

    @Bean
    @InboundChannelAdapter(channel = MySource.CHANNEL_NAME, poller = @Poller(fixedRate = "50"))
    public MessageSource<String> timerMessageSource() {
        return () -> {
            String time = new SimpleDateFormat("hh:mm:ss.SSS").format(new Date());
            return new GenericMessage<>(time);
        };
    }

}
