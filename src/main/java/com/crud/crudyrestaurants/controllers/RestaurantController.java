package com.crud.crudyrestaurants.controllers;

import com.crud.crudyrestaurants.models.Restaurant;
import com.crud.crudyrestaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    // http://localhost3000/restaurants/restaurants
    @GetMapping(value = "/restaurants", produces = {"application/json"})
    public ResponseEntity<?> listAllRestaurants(){
        List<Restaurant> myRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(myRestaurants, HttpStatus.OK);
    }

    // http://localhost3000/restaurants/restaurant/3
    @GetMapping(value = "/restaurant/{id}", produces = {"application/json"})
    public ResponseEntity<?> findRestaurantById(@PathVariable long id){
        Restaurant r = restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    // http://localhost3000/restaurants/restaurant/likename/eat
    @GetMapping(value = "/restaurant/likename/{name}", produces = {"application/json"})
    public ResponseEntity<?> findRestaurantById(@PathVariable String name){
        List<Restaurant> myRestaurants = restaurantService.findByNameLike(name);
        return new ResponseEntity<>(myRestaurants, HttpStatus.OK);
    }

}
