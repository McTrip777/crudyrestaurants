package com.crud.crudyrestaurants.services;

import com.crud.crudyrestaurants.models.Restaurant;
import com.crud.crudyrestaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "restaurantService")
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restrepos;

    @Override
    public List<Restaurant> findAllRestaurants() {
        List<Restaurant> rtnList = new ArrayList<>();
        restrepos.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    public Restaurant findRestaurantById(long id) {
        return restrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Restaurant " + id + " Not Found"));
    }

    @Override
    public List<Restaurant> findByNameLike(String thename) {
        return restrepos.findByNameContainingIgnoringCase(thename);
    }
}
