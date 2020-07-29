package com.crud.crudyrestaurants.repositories;

import com.crud.crudyrestaurants.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
