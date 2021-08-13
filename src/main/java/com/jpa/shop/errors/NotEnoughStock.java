package com.jpa.shop.errors;


public class NotEnoughStock extends Throwable {

    private final String message = "재고가 부족합니다.";

    public NotEnoughStock() {
        System.out.println(message);
    }
}
