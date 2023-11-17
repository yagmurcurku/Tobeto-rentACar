package com.tobeto.rentACar.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "plate")
    private String plate;

    @Column(name = "daily_price")
    private double daily_price;

    @Column(name = "state")
    private boolean state;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
