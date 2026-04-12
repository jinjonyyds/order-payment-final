package com.rothur.orderservice.service.impl;

import com.rothur.orderservice.dto.CreateOrderRequest;
import com.rothur.orderservice.repository.OrderRepository;
import com.rothur.orderservice.service.OrderService;
import com.rothur.orderservice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(CreateOrderRequest request) {
        Order order = Order.builder()
                .productName(request.getProductName())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .status("CREATED")
                .build();
        return orderRepository.save(order);
    }
}
