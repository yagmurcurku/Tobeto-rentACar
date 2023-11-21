package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Integer> {

}
