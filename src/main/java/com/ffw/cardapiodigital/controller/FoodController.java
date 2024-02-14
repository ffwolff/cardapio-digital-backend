package com.ffw.cardapiodigital.controller;

import com.ffw.cardapiodigital.food.Food;
import com.ffw.cardapiodigital.food.FoodRepository;
import com.ffw.cardapiodigital.food.FoodRequestDTO;
import com.ffw.cardapiodigital.food.FoodResponseDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void insertFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);

    }

    @GetMapping
    public List<FoodResponseDTO> getAll() {

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
