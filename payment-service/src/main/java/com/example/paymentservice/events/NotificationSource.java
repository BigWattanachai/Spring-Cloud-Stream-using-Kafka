package com.example.paymentservice.events;

import com.example.paymentservice.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class NotificationSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationSource.class);
    private Source source;

    @Autowired
    public NotificationSource(Source source) {
        this.source = source;
    }

    public void publishPaymentSuccess(String email, String message) {
        Notification noti = new Notification(email, message);
        LOGGER.info("email: {}, message: {}", email, message);
        source.output().send(MessageBuilder.withPayload(noti).build());
    }
}
