package com.rest.spring.services;

import com.rest.spring.models.Company;
import com.rest.spring.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements CRUDService<Company> {
    static final public String url = "api/company";

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public int addNew(Company entity) {
        entity.setCreatedOn(Date.from(Instant.now()));
       return companyRepository.save(entity).getId();
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getById(int id) {
       Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);
    }

    @Override
    public Company update(Company entity) {
        return companyRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        Company company = getById(id);
        if(company != null) {
            companyRepository.delete(company);
            return id;
        }
        return 0;
    }
}
