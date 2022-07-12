package com.sravan.jpa.service;

import com.sravan.jpa.exception.ConstraintViolationException;
import com.sravan.jpa.exception.EntityNotFoundException;
import com.sravan.jpa.model.Customer;
import com.sravan.jpa.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    CustomersRepository customersRepository;

    public Customer createCustomer(Customer customer) throws ConstraintViolationException {
        customer.setCreatedDate(Instant.now().toEpochMilli());
        try {
            return customersRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new ConstraintViolationException(e.getMessage());
        }
    }


    public Customer getCustomer(Long id) throws EntityNotFoundException{
        return findCustomerById(id);
    }


    public List<Customer> getListOfCustomers() {
        return customersRepository.findAllByIsDeletedFalse();
    }


    public Customer updateCustomer(Customer customer, Long id) throws EntityNotFoundException, ConstraintViolationException{
        Customer customerEntity = findCustomerById(id);
        customerEntity.setDrivingLicenceNumber(customer.getDrivingLicenceNumber());
        try {
            return customersRepository.save(customerEntity);
        } catch (DataIntegrityViolationException e) {
            throw new ConstraintViolationException(e.getMessage());
        }
    }

    public void deleteCustomer(Long id) throws EntityNotFoundException{
        Customer customer = findCustomerById(id);
        customer.setActive(true);
        customersRepository.save(customer);
    }


    private Customer findCustomerById(Long id) throws EntityNotFoundException
    {
        return customersRepository.findByIdAndIsDeletedFalse(id)
            .orElseThrow(() -> new EntityNotFoundException("Customer with id : " + id + " not found"));
    }
}
