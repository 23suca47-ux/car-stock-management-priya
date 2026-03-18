package com.carstock.carstock_managing_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.carstock.carstock_managing_application.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
