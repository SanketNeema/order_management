package com.sanket.order_management.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sanket.order_management.model.Order;
import com.sanket.order_management.service.order.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get order by id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }
    
    // Get order by user
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Order>> getOrderByUserId(@PathVariable Long userId) {
//    	 List<Order> order = orderService.getOrdersByUserId(userId);
//        return ResponseEntity.ok(order);
//    }

    // Delete order by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
    
}
