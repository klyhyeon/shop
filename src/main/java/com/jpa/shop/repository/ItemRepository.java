package com.jpa.shop.repository;

import com.jpa.shop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByName(String name);

    Item findByNameContains(String name);
}
