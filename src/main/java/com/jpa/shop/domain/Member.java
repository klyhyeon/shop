package com.jpa.shop.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "orders")
public class Member extends BaseEntity {

    @Builder
    public Member (String name, Address address) {
        this.name = name;
        this.address = address;
    }

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }
}
