package com.jpa.shop.repository;

import com.jpa.shop.domain.Order;
import com.jpa.shop.domain.OrderSearch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll(OrderSearch orderSearch);
}
