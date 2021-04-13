package com.rest.spring.controllers;

import com.rest.spring.models.Customer;
import com.rest.spring.services.AdminUserService;
import com.rest.spring.services.CRUDService;
import com.rest.spring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CRUDService<Customer> customerCRUDService;

    @Autowired
    public CustomerController(CRUDService<Customer> customerCRUDService) {
        this.customerCRUDService = customerCRUDService;
    }

    @GetMapping(CustomerService.url)
    public List<Customer> getAll() {
        return customerCRUDService.getAll();
    }

    @GetMapping(CustomerService.url + "/{id}")
    public Customer getOne(@PathVariable String id) {
        return customerCRUDService.getById(Integer.parseInt(id));
    }

    @PostMapping(CustomerService.url)
    public int post(@RequestBody Customer adminUser) {
        return customerCRUDService.addNew(adminUser);
    }

    @DeleteMapping(CustomerService.url + "/{id}")
    public int delete(@PathVariable String id) {
        return customerCRUDService.delete(Integer.parseInt(id));
    }
}
