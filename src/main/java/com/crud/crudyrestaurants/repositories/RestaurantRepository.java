package com.crud.crudyrestaurants.repositories;

import com.crud.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findByNameContainingIgnoringCase(String likename);
}
