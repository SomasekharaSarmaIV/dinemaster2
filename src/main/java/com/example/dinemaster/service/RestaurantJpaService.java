/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.dinemaster.service;

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.RestaurantJpaRepository;
import com.example.dinemaster.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

// Write your code here
@Service
public class RestaurantJpaService implements RestaurantRepository {

  @Autowired
  private RestaurantJpaRepository rjr;

  @Override
  public ArrayList<Restaurant> getRestaurants() {
    List<Restaurant> l = rjr.findAll();
    ArrayList<Restaurant> a = new ArrayList<>(l);
    return a;

  }

  @Override
  public Restaurant getRestaurantById(int restaurantId) {
    try {
      Restaurant restaurant = rjr.findById(restaurantId).get();
      return restaurant;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

  }

  @Override
  public Restaurant addRestaurant(Restaurant restaurant) {
    rjr.save(restaurant);
    return restaurant;
  }

  @Override
  public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant) {
    try {
      Restaurant newRestaurant = rjr.findById(restaurantId).get();
      if (restaurant.getName() != null) {
        newRestaurant.setName(restaurant.getName());
      }
      if (restaurant.getAddress() != null) {
        newRestaurant.setAddress(restaurant.getAddress());
      }
      if (restaurant.getCuisineType() != null) {
        newRestaurant.setCuisineType(restaurant.getCuisineType());
      }
      if (restaurant.getRating() != 0) {
        newRestaurant.setRating(restaurant.getRating());

      }
      rjr.save(newRestaurant);
      return newRestaurant;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public void deleteRestaurant(int restaurantId) {
    try {
      rjr.deleteById(restaurantId);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    throw new ResponseStatusException(HttpStatus.NO_CONTENT);
  }
}
