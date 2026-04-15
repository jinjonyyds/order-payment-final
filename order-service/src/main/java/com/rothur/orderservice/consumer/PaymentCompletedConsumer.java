package com.rothur.orderservice.consumer;

import com.rothur.orderservice.dto.PaymentCompletedEvent;
import com.rothur.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentCompletedConsumer {
    private final OrderService orderService;
    @KafkaListener(
            topics = "payment-completed",
            groupId = "order-group",
            containerFactory = "paymentCompletedKafkaListenerContainerFactory"
    )
    public void handlePaymentCompleted(PaymentCompletedEvent event) {
        System.out.println("Received PaymentCompletedEvent: " + event);
        orderService.updateOrderStatus(event.getOrderId(), event.getStatus());
    }
}
