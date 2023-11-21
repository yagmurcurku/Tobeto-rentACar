package com.tobeto.rentACar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    private List<RentalDetail> rentalDetailsLocationPickup;

    @OneToMany(mappedBy = "locationDelivery")
    @JsonIgnore
    private List<RentalDetail> rentalDetailsLocationDelivery;

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<Employee> employees;

}
