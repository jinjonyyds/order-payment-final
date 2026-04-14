package com.rothur.paymentservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "payments")
public class Payment {

    @Id
    private String id;

    private String orderId;
    private String status;
    private Double amount;
}
