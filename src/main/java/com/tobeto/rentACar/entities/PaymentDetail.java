package com.tobeto.rentACar.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "payment_details")
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @ManyToOne
    @JoinColumn(name = "rental_id", unique = true)
    private Rental rental;

}