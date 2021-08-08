package com.jpa.shop.domain;

public enum DeliveryStatus {
    READY("준비"), COMP("배송");

    private String value;

    DeliveryStatus(String value) {
        this.value = value;
    }
}
