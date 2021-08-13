package com.jpa.shop.domain;

import com.jpa.shop.errors.NotEnoughStock;
import com.jpa.shop.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemTest {

    @Autowired
    private ItemRepository itemRepository;

    private Item item;
    @BeforeEach
    void setUp() {
        item = Item.builder()
                    .name("소프트웨어 장인")
                    .price(15000)
                    .stockQuantity(1).build();
        itemRepository.save(item);
    }

    @Test
    @DisplayName("addStock 테스트")
    void addStock() {
        //given
        Item item = itemRepository.findByName("소프트웨어 장인");
        item.addStock(2);
        //when
        int stockQuantity = itemRepository.findByName("소프트웨어 장인").getStockQuantity();
        //then
        assertThat(stockQuantity).isEqualTo(3);
    }

    @Test
    @DisplayName("removeStock 테스트")
    void removeStock() throws NotEnoughStock {
        //when
//        item.removeStock(1);
        //then
//        assertThat(itemRepository.findByName("소프트웨어 장인").getStockQuantity())
//                .isEqualTo(0);

        //then
        assertThatThrownBy(() -> {
            item.removeStock(2);
        }).isInstanceOf(NotEnoughStock.class);
    }
}