package com.rest.spring.controllers;

import com.rest.spring.models.Company;
import com.rest.spring.services.CRUDService;
import com.rest.spring.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private final CRUDService<Company> companyCRUDService;

    @Autowired
    public CompanyController(CRUDService<Company> companyCRUDService) {
        this.companyCRUDService = companyCRUDService;
    }

    @GetMapping(CompanyService.url)
    public List<Company> getAll() {
        return companyCRUDService.getAll();
    }

    @GetMapping(CompanyService.url + "/{id}")
    public Company getOne(@PathVariable String id) {
        return companyCRUDService.getById(Integer.parseInt(id));
    }

    @PostMapping(CompanyService.url)
    public int post(@RequestBody Company company) {
        return companyCRUDService.addNew(company);
    }

    @DeleteMapping(CompanyService.url + "/{id}")
    public int delete(@PathVariable String id) {
        return companyCRUDService.delete(Integer.parseInt(id));
    }
}
