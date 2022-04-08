package com.jpa.shop.domain;

public class Product {

    private int amount;

    public boolean buy(int orderAmount) {
        if (amount - orderAmount < 0) {
            return false;
        }
        amount -= orderAmount;
        return true;
    }
}
