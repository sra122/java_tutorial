package com.sravan.jpa.service;

import com.sravan.jpa.exception.EntityNotFoundException;
import com.sravan.jpa.model.Customer;
import com.sravan.jpa.repository.CustomersRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    CustomersRepository customersRepository;

    public Customer createCustomer(Customer customer) {
        customer.setModifiedDate(new java.util.Date());
        customer.setCreatedDate(new java.util.Date());
        return customersRepository.save(customer);
    }


    public Customer getCustomer(Long id) throws EntityNotFoundException{
        return findCustomerById(id);
    }


    public List<Customer> getListOfCustomers() {
        return customersRepository.findAllByIsDeletedFalse();
    }


    public Customer updateCustomer(Customer customer, Long id) throws EntityNotFoundException{
        Customer customerEntity = findCustomerById(id);
        customerEntity.setDrivingLicenceNumber(customer.getDrivingLicenceNumber());
        customerEntity.setModifiedDate(new java.util.Date());
        return customersRepository.save(customerEntity);
    }

    public void deleteCustomer(Long id) throws EntityNotFoundException{
        Customer customer = findCustomerById(id);
        customer.setActive(true);
        customer.setModifiedDate(new java.util.Date());
        customersRepository.save(customer);
    }


    private Customer findCustomerById(Long id) throws EntityNotFoundException
    {
        return customersRepository.findByIdAndIsDeletedFalse(id)
            .orElseThrow(() -> new EntityNotFoundException("Customer with id : " + id + " not found"));
    }
}
