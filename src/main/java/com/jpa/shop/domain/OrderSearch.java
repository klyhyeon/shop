package com.jpa.shop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {

    private String memberName;

    private OrderStatus orderStatus;

}
