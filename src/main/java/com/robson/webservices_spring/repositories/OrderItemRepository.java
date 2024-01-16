package com.robson.webservices_spring.repositories;

import com.robson.webservices_spring.entities.OrderItem;
import com.robson.webservices_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
