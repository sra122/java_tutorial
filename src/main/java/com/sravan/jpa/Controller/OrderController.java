package com.sravan.jpa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sravan.jpa.Entity.Customer;
import com.sravan.jpa.Entity.Product;
import com.sravan.jpa.Repository.CustomerRepository;
import com.sravan.jpa.Repository.ProductRepository;
import com.sravan.jpa.dto.OrderRequest;
import com.sravan.jpa.dto.OrderResponse;

@RestController
public class OrderController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}
	
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/findAllProducts")
	public List<Product> findProducts() {
		return productRepository.findAll();
	}
	
	//@GetMapping("/getOrderDetails")
	//public List<OrderResponse> findOrderDetails() {
	//	return customerRepository.getOrderDetails();
	//}

}
