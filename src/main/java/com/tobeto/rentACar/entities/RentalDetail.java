package com.tobeto.rentACar.entities;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "rental_details")
public class RentalDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rental_id", referencedColumnName = "id")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "location_pickup_id")
    private Location locationPickup;

    @ManyToOne
    @JoinColumn(name = "location_delivery_id")
    private Location locationDelivery;

}
