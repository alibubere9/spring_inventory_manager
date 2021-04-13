package com.rest.spring.services;

import com.rest.spring.models.Company;
import com.rest.spring.models.MobilePhone;
import com.rest.spring.repositories.MobilePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MobilePhoneService implements CRUDService<MobilePhone> {
    static final public String url = "api/mobilePhone";

    private MobilePhoneRepository mobilePhoneRepository;

    @Autowired
    public MobilePhoneService(MobilePhoneRepository mobilePhoneRepository) {
        this.mobilePhoneRepository = mobilePhoneRepository;
    }

    public MobilePhoneService() {
    }

    @Override
    public int addNew(MobilePhone mobilePhone) {
        mobilePhone.setCreatedOn(Date.from(Instant.now()));
        return mobilePhoneRepository.save(mobilePhone).getId();
    }

    @Override
    public List<MobilePhone> getAll() {
        return mobilePhoneRepository.findAll();
    }

    @Override
    public MobilePhone getById(int id) {
        Optional<MobilePhone> mobilePhone = mobilePhoneRepository.findById(id);
        return mobilePhone.orElse(null);
    }

    @Override
    public MobilePhone update(MobilePhone mobilePhone) {
        return mobilePhoneRepository.save(mobilePhone);
    }

    @Override
    public int delete(int id) {
        MobilePhone mobilePhone = getById(id);
        if(mobilePhone != null) {
            mobilePhoneRepository.delete(mobilePhone);
            return id;
        }
        return 0;
    }
}
