package com.rest.spring.services;


import com.rest.spring.models.Order;
import com.rest.spring.models.StockItem;
import com.rest.spring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements CRUDService<Order> {
    static final public String url = "api/order";

    private OrderRepository orderRepository;

    private StockItemService stockItemService;

    @Autowired
    public OrderService(OrderRepository orderRepository, StockItemService stockItemService) {
        this.orderRepository = orderRepository;
        this.stockItemService = stockItemService;
    }

    public OrderService() {
    }

    @Override
    public int addNew(Order order) {
        order.setCreatedOn(Date.from(Instant.now()));
        updateStocks(order);
        return orderRepository.save(order).getId();

    }

    private void updateStocks(Order order) {
        int orderQuantity = order.getStockItem().getQuantity();
        StockItem item = stockItemService.getById(order.getStockItem().getId());
        int updatedQuantity = item.getQuantity() - orderQuantity;
        item.setQuantity(updatedQuantity);
        stockItemService.update(item);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(int id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public int delete(int id) {
        Order order = getById(id);
        if (order != null) {
            orderRepository.delete(order);
            return id;
        }
        return 0;
    }
}