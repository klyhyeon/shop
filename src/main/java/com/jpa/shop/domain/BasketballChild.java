package com.jpa.shop.domain;

public class BasketballChild implements ProductInterface {
    @Override
    public boolean buy(int orderAmount) {
        return false;
    }
}
