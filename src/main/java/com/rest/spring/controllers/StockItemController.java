package com.rest.spring.controllers;

import com.rest.spring.models.StockItem;
import com.rest.spring.services.CRUDService;
import com.rest.spring.services.StockItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockItemController {

    private final CRUDService<StockItem> stockItemCRUDService;

    @Autowired
    public StockItemController(CRUDService<StockItem> stockItemCRUDService) {
        this.stockItemCRUDService = stockItemCRUDService;
    }

    @GetMapping(StockItemService.url)
    public List<StockItem> getAll() {
        return stockItemCRUDService.getAll();
    }

    @GetMapping(StockItemService.url + "/{id}")
    public StockItem getOne(@PathVariable String id) {
        return stockItemCRUDService.getById(Integer.parseInt(id));
    }

    @PostMapping(StockItemService.url)
    public int post(@RequestBody StockItem adminUser) {
        return stockItemCRUDService.addNew(adminUser);
    }

    @DeleteMapping(StockItemService.url + "/{id}")
    public int delete(@PathVariable String id) {
        return stockItemCRUDService.delete(Integer.parseInt(id));
    }
}
