package com.jpa.shop.service;

import com.jpa.shop.domain.*;
import com.jpa.shop.errors.NotEnoughStock;
import com.jpa.shop.repository.OrderRepository;
import com.jpa.shop.repository.OrderRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private MemberService memberService;
    private OrderRepository orderRepository;
    private ItemService itemService;
    private OrderRepositorySupport orderRepositorySupport;

    @Autowired
    public OrderService(MemberService memberService, OrderRepository orderRepository, ItemService itemService,
            OrderRepositorySupport orderRepositorySupport) {
        this.memberService = memberService;
        this.orderRepository = orderRepository;
        this.itemService = itemService;
        this.orderRepositorySupport = orderRepositorySupport;
    }

    /** 주문 */
    public Long order(Long memberId, Long itemId, int count) throws NotEnoughStock {
        Member member = memberService.findById(memberId);
        Item item = itemService.findById(itemId);
        Delivery delivery = Delivery.builder()
                                    .address(member.getAddress()).build();

        OrderItem orderItem = OrderItem.builder()
                                    .item(item)
                                    .orderPrice(item.getPrice())
                                    .count(count).build();

        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    /** 주문취소 */
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.cancel();
    }

    /** 주문검색 */
    public List<Order> findAll(OrderSearch orderSearch) {
        return orderRepositorySupport.findAll(orderSearch);
    }
}
