package com.jpa.shop.repository;

import com.jpa.shop.config.QueryDSLConfig;
import com.jpa.shop.domain.*;
import com.jpa.shop.errors.NotEnoughStock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(QueryDSLConfig.class)
class OrderRepositorySupportTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MemberRepository memberRepository;

    private Item item;

    @BeforeEach
    void setUp() throws NotEnoughStock {
        //given
        Long memberId = 1L;
        Item item = itemRepository.findByNameContains("소프트웨어");
        int count = 1;
        Member member = memberRepository.findById(memberId).orElseThrow();
        Delivery delivery = Delivery.builder()
                .address(member.getAddress()).build();
        OrderItem orderItem = OrderItem.builder()
                .item(item)
                .orderPrice(item.getPrice())
                .count(count).build();
        Order order = Order.createOrder(member, delivery, orderItem);
        order.setStatus(OrderStatus.ORDER);
        orderRepository.save(order);
    }

    @Test
    @DisplayName("findAll 테스트")
    void findAllTest() {
        //given
        List<Order> orders;
        OrderSearch orderSearch = OrderSearch.builder()
                                            .memberName("yuhyeon")
                                            .orderStatus(OrderStatus.ORDER).build();
        //when
        orders = orderRepository.findAll(orderSearch);
        //then
        assertThat(orders.get(0).getMember()).isNotNull();
    }
}