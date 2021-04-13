

package com.rest.spring.controllers;

        import com.rest.spring.models.Order;
        import com.rest.spring.services.AdminUserService;
        import com.rest.spring.services.CRUDService;
        import com.rest.spring.services.OrderService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
public class OrderController {

    private final CRUDService<Order> orderCRUDService;

    @Autowired
    public OrderController(CRUDService<Order> orderCRUDService) {
        this.orderCRUDService = orderCRUDService;
    }

    @GetMapping(OrderService.url)
    public List<Order> getAll() {
        return orderCRUDService.getAll();
    }

    @GetMapping(OrderService.url + "/{id}")
    public Order getOne(@PathVariable String id) {
        return orderCRUDService.getById(Integer.parseInt(id));
    }

    @PostMapping(OrderService.url)
    public int post(@RequestBody Order adminUser) {
        return orderCRUDService.addNew(adminUser);
    }

    @DeleteMapping(OrderService.url + "/{id}")
    public int delete(@PathVariable String id) {
        return orderCRUDService.delete(Integer.parseInt(id));
    }
}

