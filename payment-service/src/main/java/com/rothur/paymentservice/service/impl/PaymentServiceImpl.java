package com.rothur.paymentservice.service.impl;

import com.rothur.paymentservice.dto.OrderCreatedEvent;
import com.rothur.paymentservice.dto.PaymentCompletedEvent;
import com.rothur.paymentservice.model.Payment;
import com.rothur.paymentservice.repository.PaymentRepository;
import com.rothur.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final KafkaTemplate<String, PaymentCompletedEvent> kafkaTemplate;


    @Override
    public void processPayment(OrderCreatedEvent event) {
        //create Payment record
        Payment payment = Payment.builder()
                .orderId(event.getOrderId())
                .amount(event.getAmount())
                .status("Paid")
                .timestamp(System.currentTimeMillis())
                .build();
        paymentRepository.save(payment);
        System.out.println("Payment saved " + payment);

        //create PaymentCompletedEvent
        PaymentCompletedEvent completedEvent = new PaymentCompletedEvent(
                payment.getOrderId(),
                "PAID",
                System.currentTimeMillis()
        );

        //send message to kafka
        kafkaTemplate.send("payment-completed", completedEvent);
        System.out.println("PaymentCompletedEvent sent " + completedEvent);

    }
}
