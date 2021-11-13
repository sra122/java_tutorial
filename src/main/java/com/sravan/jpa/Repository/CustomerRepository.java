package com.sravan.jpa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sravan.jpa.Entity.Customer;
import com.sravan.jpa.dto.OrderResponse;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	//@Query("Select new com.sravan.jpa.dto.OrderResponse(c.name, p.productName) from  customers c join c.products p")
	//public List<OrderResponse> getOrderDetails();

}
