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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rental_id", referencedColumnName = "id")
    private Rental rental;


}