package com.rothur.paymentservice.consumer;

import com.rothur.paymentservice.dto.OrderCreatedEvent;
import com.rothur.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentConsumer {

    private final PaymentService paymentService;

    @KafkaListener(topics = "order-created", groupId = "payment-group")
    public void handleOrderCreated(OrderCreatedEvent event) {
        System.out.println("Received order event " + event);
        paymentService.processPayment(event);
    }
}
