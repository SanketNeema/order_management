package com.sanket.order_management.service.order;

import com.sanket.order_management.model.Order;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    void deleteOrder(Long id);
//    List<Order> getOrdersByUserId(Long userId);
}
