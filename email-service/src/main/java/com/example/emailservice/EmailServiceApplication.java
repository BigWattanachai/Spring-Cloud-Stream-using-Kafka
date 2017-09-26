package com.example.emailservice;

import com.example.emailservice.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class EmailServiceApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EmailServiceApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void receivedSink(Notification notification) {
        //do business logic
        LOGGER.info(" Received Notification: {}", notification);
    }
}


