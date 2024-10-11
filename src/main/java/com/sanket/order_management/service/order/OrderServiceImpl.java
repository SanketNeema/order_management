package com.sanket.order_management.service.order;
//package com.example.orderservice.service.impl;
//import com.sanket.order_management.service.OrderService;

import com.sanket.order_management.model.Order;
import com.sanket.order_management.repository.order.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

//	@Override
//	public List<Order> getOrdersByUserId(Long userId) {
//		return orderRepository.findByUserId(userId);
//	}
}
