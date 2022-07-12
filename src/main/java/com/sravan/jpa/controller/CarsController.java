package com.sravan.jpa.controller;

import com.sravan.jpa.exception.ConstraintViolationException;
import com.sravan.jpa.exception.EntityNotFoundException;
import com.sravan.jpa.model.Car;
import com.sravan.jpa.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarsController
{
    @Autowired CarService carService;

    @PostMapping
    public Car createCar(@RequestBody Car car) throws ConstraintViolationException
    {
        return carService.createCar(car);
    }


    @GetMapping
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) throws EntityNotFoundException
    {
        return carService.getCar(id);
    }

    @PutMapping("/{id}")
    public Car updateCar(@RequestBody Car car, @PathVariable Long id) throws EntityNotFoundException, ConstraintViolationException
    {
        return carService.updateCar(car, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) throws EntityNotFoundException {
        carService.deleteCar(id);
    }
}
