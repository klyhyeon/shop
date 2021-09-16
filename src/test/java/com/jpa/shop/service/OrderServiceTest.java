//package com.jpa.shop.service;
//
//import com.jpa.shop.domain.Item;
//import com.jpa.shop.errors.NotEnoughStock;
//import com.jpa.shop.repository.ItemRepository;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.transaction.Transactional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class OrderServiceTest {
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private ItemRepository itemRepository;
//
//    private Item item;
//
//    @BeforeEach
//    void setUp() {
//        item = Item.builder()
//                .name("소프트웨어 장인")
//                .price(15000)
//                .stockQuantity(1).build();
//        itemRepository.save(item);
//    }
//
//    @Test
//    @DisplayName("order 테스트")
//    void orderTest() throws NotEnoughStock {
//        //given
//        Long memberId = 1L;
//        //when
//        Long result = orderService.order(1L, item.getId(), 1);
//        //then
//        assertThat(result).isGreaterThan(0L);
//    }
//}