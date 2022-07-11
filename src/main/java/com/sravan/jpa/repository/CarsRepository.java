package com.sravan.jpa.repository;

import com.sravan.jpa.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {

    @Query(value = "select * from cars where is_deleted=false", nativeQuery = true)
    List<Car> findAllByIsDeletedFalse();

    @Query(value = "select * from cars where id = (:id) and is_deleted=false", nativeQuery = true)
    Optional<Car> findByIdAndIsDeletedFalse(Long id);
}
