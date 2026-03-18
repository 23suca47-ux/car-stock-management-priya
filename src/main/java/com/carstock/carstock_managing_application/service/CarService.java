package com.carstock.carstock_managing_application.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.carstock.carstock_managing_application.entity.Car;
import com.carstock.carstock_managing_application.repository.CarRepository;

@Service
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> getAllCars() {
        return repository.findAll();
    }

    public Car saveCar(Car car) {
        return repository.save(car);
    }

    public Optional<Car> getCarById(Long id) {
        return repository.findById(id);
    }

    public void deleteCar(Long id) {
        repository.deleteById(id);
    }
}
