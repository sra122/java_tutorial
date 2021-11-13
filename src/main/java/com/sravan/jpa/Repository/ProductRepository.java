package com.sravan.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sravan.jpa.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
