package com.rest.spring.repositories;

import com.rest.spring.models.MobilePhone;
import com.rest.spring.models.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockItemRepository extends JpaRepository<StockItem, Integer> {
    public StockItem findByMobilePhoneEquals(MobilePhone mobilePhone);
    public StockItem findAllByQuantityGreaterThanEqual(int quantity);
}
