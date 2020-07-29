package com.crud.crudyrestaurants.services;

import com.crud.crudyrestaurants.models.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> findAllRestaurants();

    Restaurant findRestaurantById(long id);

    List<Restaurant> findByNameLike(String thename);
}
