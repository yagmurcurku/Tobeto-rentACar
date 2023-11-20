package com.tobeto.rentACar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.rentACar.entities.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "models")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @OneToMany(mappedBy = "model")
    @JsonIgnore
    private List<Car> cars;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
