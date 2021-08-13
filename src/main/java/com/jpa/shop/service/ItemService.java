package com.jpa.shop.service;

import com.jpa.shop.domain.Item;
import com.jpa.shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

    public Item findById(Long id) {
        return itemRepository.findById(id)
                            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findByName(String name) {
        return itemRepository.findByName(name);
    }

}
