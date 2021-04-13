package com.rest.spring.services;

import com.rest.spring.models.AdminUser;
import com.rest.spring.repositories.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService implements CRUDService<AdminUser> {
    static final public String url = "api/adminUser";

    private AdminUserRepository adminUserRepository;

    @Autowired
    public AdminUserService(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    public AdminUserService() {
    }

    @Override
    public int addNew(AdminUser adminUser) {
        adminUser.setCreatedOn(Date.from(Instant.now()));
       return adminUserRepository.save(adminUser).getId();
    }

    @Override
    public List<AdminUser> getAll() {
        return adminUserRepository.findAll();
    }

    @Override
    public AdminUser getById(int id) {
        Optional<AdminUser> adminUser = adminUserRepository.findById(id);
        return adminUser.orElse(null);
    }

    @Override
    public AdminUser update(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }

    @Override
    public int delete(int id) {
        AdminUser adminUser = getById(id);
        if (adminUser != null) {
            adminUserRepository.delete(adminUser);
            return id;
        }
        return 0;
    }
}


