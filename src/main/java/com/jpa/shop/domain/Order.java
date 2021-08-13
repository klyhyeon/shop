package com.jpa.shop.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "ORDERS")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity{

    public static Order createOrder(Member member, Delivery delivery, OrderItem orderItem) {
        Order order = Order.builder()
                            .delivery(delivery)
                            .member(member).build();
        order.addOrderItem(orderItem);
        return order;
    }

    @Builder
    public Order(Member member, Delivery delivery, OrderStatus status) {
        this.member = member;
        this.delivery = delivery;
        this.status = status;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY) //교재엔 cascade ALL
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY) //교재엔 cascade ALL
    private Delivery delivery;

    @CreatedDate
    private LocalDateTime orderDate;

    private OrderStatus status;

    //==setter==//
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    //==비즈니스 로직==//
    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP)
            throw new RuntimeException("이미 배송완료된 상품은 취소가 불가능합니다.");
        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem: orderItems)
            orderItem.cancel();
    }

    public int getTotalPrice() {
        return orderItems.stream().map(i -> i.getOrderPrice())
                            .reduce(0, (a,b) -> (a + b));
    }
}
