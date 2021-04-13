package com.rest.spring.services;


import com.rest.spring.models.MobilePhone;
import com.rest.spring.models.StockItem;
import com.rest.spring.repositories.StockItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StockItemService implements CRUDService<StockItem> {
    static final public String url = "api/stockItem";

    private StockItemRepository stockItemRepository;

    @Autowired
    public StockItemService(StockItemRepository stockItemRepository) {
        this.stockItemRepository = stockItemRepository;
    }

    public StockItemService() {
    }

    @Override
    public int addNew(StockItem stockItem) {
        MobilePhone mobilePhone = stockItem.getMobilePhone();
        StockItem stockItemExists = stockItemRepository.findByMobilePhoneEquals(mobilePhone);
        if (stockItemExists != null) {
            stockItemExists.setQuantity(stockItemExists.getQuantity() + stockItem.getQuantity());
            return setDateAndSaveStockItem(stockItemExists);
        }
        return setDateAndSaveStockItem(stockItem);
    }

    private int setDateAndSaveStockItem(StockItem stockItem) {
        stockItem.setCreatedOn(Date.from(Instant.now()));
        return stockItemRepository.save(stockItem).getId();
    }

    @Override
    public List<StockItem> getAll() {
        return stockItemRepository.findAll();
    }

    @Override
    public StockItem getById(int id) {
        Optional<StockItem> stockItem = stockItemRepository.findById(id);
        return stockItem.orElse(null);
    }

    @Override
    public StockItem update(StockItem order) {
        return stockItemRepository.save(order);
    }

    @Override
    public int delete(int id) {
        StockItem stockItem = getById(id);
        if (stockItem != null) {
            stockItemRepository.delete(stockItem);
            return id;
        }
        return 0;
    }
}