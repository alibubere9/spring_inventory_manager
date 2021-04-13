package com.rest.spring.services;

import com.rest.spring.models.Customer;
import com.rest.spring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CRUDService<Customer> {
    static final public String url = "api/customer";

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerService() {
    }

    @Override
    public int addNew(Customer customer) {
        customer.setCreatedOn(Date.from(Instant.now()));
        return customerRepository.save(customer).getId();
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public int delete(int id) {
        Customer customer = getById(id);
        if (customer != null) {
            customerRepository.delete(customer);
            return id;
        }
        return 0;
    }
}
