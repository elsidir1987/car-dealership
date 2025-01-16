package com.example.car_dealership.controller;

import com.example.car_dealership.model.Car;
import com.example.car_dealership.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/customer/dashboard/cars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/dealership/dashboard/cars")
    public List<Car> getDealershipCars(@RequestParam int dealershipId) {
        return carService.getDealershipCars(dealershipId);
    }

    @PostMapping("/dealership/dashboard/add-car")
    public ResponseEntity<Car> addCar(@RequestParam int dealershipId, @RequestBody Car car) {
        Car savedCar = carService.addCar(dealershipId, car);
        return ResponseEntity.ok(savedCar);
    }

    @PostMapping("/dealership/dashboard/edit-car")
    public ResponseEntity<Car> editCar(@RequestParam int carId, @RequestBody Car car) {
        Car updatedcar = carService.editCar(carId, car);
        return ResponseEntity.ok(updatedcar);
    }
}
