package com.rest.spring.controllers;

import com.rest.spring.models.MobilePhone;
import com.rest.spring.services.CRUDService;
import com.rest.spring.services.MobilePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MobilePhoneController {

    private final CRUDService<MobilePhone> mobilePhoneService;

    @Autowired
    public MobilePhoneController(CRUDService<MobilePhone> mobilePhoneService) {
        this.mobilePhoneService = mobilePhoneService;
    }

    @GetMapping(MobilePhoneService.url)
    public List<MobilePhone> getAllMobilePhones() {
        return mobilePhoneService.getAll();
    }

    @GetMapping(MobilePhoneService.url + "/{id}")
    public MobilePhone getOne(@PathVariable String id) {
        return mobilePhoneService.getById(Integer.parseInt(id));
    }

    @PostMapping(MobilePhoneService.url)
    public int postPhone(@RequestBody MobilePhone phone) {
        return mobilePhoneService.addNew(phone);
    }

    @DeleteMapping(MobilePhoneService.url + "/{id}")
    public int deletePhone(@PathVariable String id) {
        return mobilePhoneService.delete(Integer.parseInt(id));
    }
}
