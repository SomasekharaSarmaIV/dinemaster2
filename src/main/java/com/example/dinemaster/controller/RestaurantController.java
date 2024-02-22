/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.dinemaster.controller;

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.service.RestaurantJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

// Write your code here
@RestController
public class RestaurantController {
  @Autowired
  private RestaurantJpaService rjs;

  @GetMapping("/restaurants")
  public ArrayList<Restaurant> getRestaurants() {
    return rjs.getRestaurants();

  }

  @GetMapping("/restaurants/{restaurantId}")
  public Restaurant getRestaurantById(@PathVariable("resaurantId") int restaurantId) {
    return rjs.getRestaurantById(restaurantId);
  }

  @PostMapping("/restaurants")
  public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
    return rjs.addRestaurant(restaurant);
  }

  @PutMapping("/restaurants/{restaurantId}")
  public Restaurant updateRestaurant(@PathVariable("restaurantId") int restaurantId, Restaurant restaurant) {
    return rjs.updateRestaurant(restaurantId, restaurant);
  }

  @DeleteMapping("/restaurants/{restaurantId}")

  public void deleteRestaurant(@PathVariable("restaurantId") int restaurantId) {
    rjs.deleteRestaurant(restaurantId);
  }

}