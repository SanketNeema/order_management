package com.sanket.order_management.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.sanket.order_management.enums.PaymentMethod;
import com.sanket.order_management.enums.PaymentStatus;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus;

    @Column(nullable = false)
    private Double amount;

    private LocalDateTime paymentDate = LocalDateTime.now();

    // Getters and Setters
}

