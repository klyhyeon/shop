package com.jpa.shop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderSearch {

    private String memberName;

    private OrderStatus orderStatus;

}
