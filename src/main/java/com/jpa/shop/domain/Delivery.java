package com.jpa.shop.domain;

import lombok.Getter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@Getter
public class Delivery extends BaseEntity {

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    private DeliveryStatus status;

    public void setOrder(Order order) {
        this.order = order;
    }
}