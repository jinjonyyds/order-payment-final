package com.rothur.orderservice.service;

import com.rothur.orderservice.dto.CreateOrderRequest;
import com.rothur.orderservice.model.Order;

public interface OrderService {
    Order createOrder(CreateOrderRequest request);
}
