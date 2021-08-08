package com.jpa.shop.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private int orderPrice;

    private int count;

    public void setOrder(Order order) {
        this.order = order;
    }
}