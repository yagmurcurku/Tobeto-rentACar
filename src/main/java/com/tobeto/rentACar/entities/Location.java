package com.tobeto.rentACar.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "branch_office")
    private String branchOffice;

    @Column(name = "office_phone")
    private String officePhone;

    @OneToMany(mappedBy = "locationPickup")
    private List<RentalDetail> rentalDetailsLocationPickup;

    @OneToMany(mappedBy = "locationDelivery")
    private List<RentalDetail> rentalDetailsLocationDelivery;

    @OneToMany(mappedBy = "location")
    private List<Employee> employees;
}
