package com.rest.spring.repositories;

import com.rest.spring.models.MobilePhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobilePhoneRepository extends JpaRepository<MobilePhone, Integer>  {
}
