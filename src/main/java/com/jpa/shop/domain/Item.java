package com.jpa.shop.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "ITEM")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ITEM_TYPE", discriminatorType = DiscriminatorType.STRING)
@Getter
public class Item extends BaseEntity {

    private String name;

    private int price;

    private int stockQuantity;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<CategoryItem> categoryItems = new ArrayList<>();

}