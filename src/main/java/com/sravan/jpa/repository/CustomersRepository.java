package com.sravan.jpa.repository;

import com.sravan.jpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Long>
{
    @Query(value = "select * from customers where is_deleted=false", nativeQuery = true)
    List<Customer> findAllByIsDeletedFalse();

    @Query(value = "select * from customer where id = (:id) and is_deleted = false", nativeQuery = true)
    Optional<Customer> findByIdAndIsDeletedFalse(Long id);
}
