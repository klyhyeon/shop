package com.jpa.shop.repository;

import com.jpa.shop.domain.Order;
import com.jpa.shop.domain.OrderSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepositorySupport {

    List<Order> findAll(OrderSearch orderSearch);
}
