package com.sanket.order_management.repository.order;


import com.sanket.order_management.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
//	List<Order> findByUserId(Long userId);
}
