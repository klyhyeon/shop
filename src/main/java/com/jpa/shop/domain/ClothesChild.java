package com.jpa.shop.domain;

public class ClothesChild extends Product {

    private static int amount = 5;
    private static final ClothesChild CC = new ClothesChild();

    private ClothesChild() {
    }

    public static ClothesChild getInstance() {
        return CC;
    }

    @Override
    public boolean buy(int orderAmount) {
        if (amount - orderAmount < 0) {
            return false;
        }
        amount -= orderAmount;
        return true;
    }
}
