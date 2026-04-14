package com.rothur.paymentservice.consumer;

import com.rothur.paymentservice.dto.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {
    @KafkaListener(topics = "order-created", groupId = "payment-group")
    public void consume(OrderCreatedEvent event) {
        System.out.println("Received order event " + event);

    }
}
