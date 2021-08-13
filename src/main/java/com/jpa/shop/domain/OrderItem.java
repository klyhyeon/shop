package com.jpa.shop.domain;

import com.jpa.shop.errors.NotEnoughStock;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem extends BaseEntity {

    @Builder
    public OrderItem createOrderItem(Item item, Order order, int orderPrice, int count)
            throws NotEnoughStock {
        this.item = item;
        this.order = order;
        this.orderPrice = orderPrice;
        this.count = count;
        item.removeStock(count);
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private int orderPrice;

    private int count;

    public void setOrder(Order order) {
        this.order = order;
    }

    //==비즈니스 로직==//
    //주문취소
    public void cancel() {
        getItem().addStock(count);
    }
    //주문가격 조회
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}