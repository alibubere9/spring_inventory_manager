package com.rest.spring.controllers;

import com.rest.spring.models.AdminUser;
import com.rest.spring.services.AdminUserService;
import com.rest.spring.services.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminUserController {

    private final CRUDService<AdminUser> adminUserCRUDService;

    @Autowired
    public AdminUserController(CRUDService<AdminUser> adminUserCRUDService) {
        this.adminUserCRUDService = adminUserCRUDService;
    }

    @GetMapping(AdminUserService.url)
    public List<AdminUser> getAll() {
        return adminUserCRUDService.getAll();
    }

    @GetMapping(AdminUserService.url + "/{id}")
    public AdminUser getOne(@PathVariable String id) {
        return adminUserCRUDService.getById(Integer.parseInt(id));
    }

    @PostMapping(AdminUserService.url)
    public int post(@RequestBody AdminUser adminUser) {
        return adminUserCRUDService.addNew(adminUser);
    }

    @DeleteMapping(AdminUserService.url + "/{id}")
    public int delete(@PathVariable String id) {
        return adminUserCRUDService.delete(Integer.parseInt(id));
    }
}
