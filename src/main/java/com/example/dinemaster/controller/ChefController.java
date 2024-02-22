package com.example.dinemaster.controller;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.service.ChefJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

// Write your code here
@RestController
public class ChefController {
  @Autowired
  private ChefJpaService cjs;

  @GetMapping("/restaurants/chefs")
  public ArrayList<Chef> getChefs() {
    return cjs.getChefs();

  }

  @GetMapping("/restaurants/chefs/{chefId}")
  public Chef getChefById(@PathVariable("chefId") int chefId) {
    return cjs.getChefById(chefId);
  }

  @PostMapping("/restaurants/chefs")
  public Chef addChef(@RequestBody Chef chef) {
    return cjs.addChef(chef);
  }

  @PutMapping("/restaurants/chefs/{chefId}")
  public Chef updateChef(@PathVariable("chefId") int chefId, Chef chef) {
    return cjs.updateChef(chefId, chef);
  }

  @DeleteMapping("/restaurants/chefs/{chefId}")
  public void deleteChef(@PathVariable("chefId") int chefId) {
    cjs.deleteChef(chefId);
  }

  @GetMapping("/chefs/{chefId}/restaurant")
  public Restaurant getChefRestaurant(@PathVariable int chefId) {
    return cjs.getChefRestaurant(chefId);
  }

}