package com.sravan.jpa.service;

import com.sravan.jpa.exception.EntityNotFoundException;
import com.sravan.jpa.model.Car;
import com.sravan.jpa.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService
{
    @Autowired CarsRepository carsRepository;

    public Car createCar(Car car) {
        return carsRepository.save(car);
    }

    public Car getCar(Long id) throws EntityNotFoundException {
        return findCarById(id);
    }

    public List<Car> getCars() {
        return carsRepository.findAllByIsDeletedFalse();
    }

    public Car updateCar(Car car, Long id) throws EntityNotFoundException {
        Car carEntity = findCarById(id);

        carEntity.setColor(car.getColor());
        carEntity.setBrand(car.getBrand());
        carEntity.setMillage(car.getMillage());
        carEntity.setModel(car.getModel());
        carEntity.setLicencePlate(car.getLicencePlate());
        carEntity.setModifiedDate(new java.util.Date());
        return carsRepository.save(carEntity);
    }


    public void deleteCar(Long id) throws EntityNotFoundException {
        Car car = findCarById(id);
        car.setIsDeleted(true);
        car.setModifiedDate(new java.util.Date());
        carsRepository.save(car);
    }

    private Car findCarById(Long id) throws EntityNotFoundException
    {
        return carsRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new EntityNotFoundException("Car not found with id: " + id));
    }
}
