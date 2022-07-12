package com.sravan.jpa.controller;

import com.sravan.jpa.exception.ConstraintViolationException;
import com.sravan.jpa.exception.EntityNotFoundException;
import com.sravan.jpa.model.Customer;
import com.sravan.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomersController
{
    @Autowired CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) throws ConstraintViolationException
    {
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getListOfCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) throws EntityNotFoundException
    {
        return customerService.getCustomer(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) throws EntityNotFoundException, ConstraintViolationException
    {
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) throws EntityNotFoundException{
        customerService.deleteCustomer(id);
    }
}
