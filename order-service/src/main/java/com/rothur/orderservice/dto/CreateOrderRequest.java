package com.rothur.orderservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateOrderRequest {

    @NotBlank
    private String productName;

    @Min(1)
    private Integer quantity;

    @Min(0)
    private Double price;
}
