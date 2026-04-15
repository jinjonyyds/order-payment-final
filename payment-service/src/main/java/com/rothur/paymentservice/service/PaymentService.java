package com.rothur.paymentservice.service;

import com.rothur.paymentservice.dto.OrderCreatedEvent;
import com.rothur.paymentservice.model.Payment;

public interface PaymentService {
    void processPayment(OrderCreatedEvent event);
}
