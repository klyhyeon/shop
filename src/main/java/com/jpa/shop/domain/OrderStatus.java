package com.jpa.shop.domain;

public enum OrderStatus {
    ORDER("주문완료"), CANCEL("주문취소");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }
}
