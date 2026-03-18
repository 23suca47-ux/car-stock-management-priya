package com.carstock.carstock_managing_application.entity;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public void setId(Long id) {
        this.id = id;
    }

    private String brand;
    private String model;
    private double price;
    private int quantity;

    public Car() {}

    public Car(String brand, String model, double price, int quantity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() { return id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
