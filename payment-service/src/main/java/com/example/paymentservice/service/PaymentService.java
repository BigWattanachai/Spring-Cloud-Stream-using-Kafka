package com.example.paymentservice.service;

import com.example.paymentservice.events.NotificationSource;
import com.example.paymentservice.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private NotificationSource notificationSource;

    public PaymentService(NotificationSource notificationSource) {
        this.notificationSource = notificationSource;
    }

    public Payment pay(Payment payment) {
        //do business logic
        notificationPaymentSuccess(payment.getEmail(), "payment success message");
        payment.setPaymentStatus("success");
        return payment;
    }

    private void notificationPaymentSuccess(String email, String message) {
        notificationSource.publishPaymentSuccess(email, message);
    }
}
