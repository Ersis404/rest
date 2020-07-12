package com.example.rest.api;


import com.example.rest.model.Order;
import com.example.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/order",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ControllerOrder {
    private final OrderService orderService;

    @Autowired
    public ControllerOrder(OrderService orderService){ this.orderService = orderService; }

    @RequestMapping(value = "/addNewOrder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addNewOrder(@RequestBody Order newOrder){
        orderService.addNewOrderOrChange(newOrder);
    }

    @RequestMapping(value = "/delOrder/{orderId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delOrder(@PathVariable("orderId") Long orderId){
        orderService.delOrder(orderId);
    }

    @RequestMapping(value = "/editOrder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void editOrder(@RequestBody Order newOrder){
        orderService.addNewOrderOrChange(newOrder);
    }

    @RequestMapping(value = "/getOneOrderById/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOneOrderById(@PathVariable("orderId") Long orderId){
        return orderService.getOneOrderById(orderId);
    }
}
