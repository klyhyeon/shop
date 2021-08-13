package com.jpa.shop.service;

import com.jpa.shop.domain.*;
import com.jpa.shop.errors.NotEnoughStock;
import com.jpa.shop.repository.MemberService;
import com.jpa.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;

@Service
@Transactional
public class OrderService {

    private MemberService memberService;
    private OrderRepository orderRepository;
    private ItemService itemService;

    @Autowired
    public OrderService(MemberService memberRepository, OrderRepository orderRepository, ItemService itemService) {
        this.memberService = memberRepository;
        this.orderRepository = orderRepository;
        this.itemService = itemService;
    }

    /** 주문 */
    public Long order(Long memberId, Long itemId, int count) throws NotEnoughStock {
        Member member = memberService.findById(memberId).orElseThrow();
        Item item = itemService.findById(itemId);
        Delivery delivery = Delivery.builder()
                                    .address(member.getAddress()).build();

        OrderItem orderItem = OrderItem.builder()
                                    .item(item)
                                    .orderPrice(item.getPrice())
                                    .count(count).build();
        //TODO: createOrder 메서드 만들기
//        Order order = Order.builder()
//                            .member(member)
//                            .delivery(delivery)
//                            .status(OrderStatus.ORDER).build();

//        orderRepository.save(order);
        return null;
    }
}
