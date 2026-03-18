package com.carstock.carstock_managing_application.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.carstock.carstock_managing_application.entity.Car;
import com.carstock.carstock_managing_application.service.CarService;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin("*")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return service.getAllCars();
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return service.saveCar(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        car.setId(id);
        return service.saveCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        service.deleteCar(id);
    }
}
