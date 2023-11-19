package com.tobeto.rentACar.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "rental")
    private Invoice invoice;

    @OneToOne(mappedBy = "rental")
    private RentalDetail rentalDetail;

}
