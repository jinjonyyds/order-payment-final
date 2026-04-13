package com.rothur.orderservice.service.impl;

import com.rothur.orderservice.dto.CreateOrderRequest;
import com.rothur.orderservice.dto.OrderCreatedEvent;
import com.rothur.orderservice.repository.OrderRepository;
import com.rothur.orderservice.service.OrderService;
import com.rothur.orderservice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    @Override
    public Order createOrder(CreateOrderRequest request) {

        // create order object
        Order order = Order.builder()
                .productName(request.getProductName())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .status("CREATED")
                .build();

        //save order
        Order savedOrder = orderRepository.save(order);

        //generate kafka event
        OrderCreatedEvent event = new OrderCreatedEvent(
                savedOrder.getId(),
                savedOrder.getPrice(),
                savedOrder.getStatus(),
                System.currentTimeMillis()
        );

        //send message to kafka
        kafkaTemplate.send("order-created", event);
        return savedOrder;
    }
}
