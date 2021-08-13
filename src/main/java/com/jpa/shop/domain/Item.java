package com.jpa.shop.domain;

import com.jpa.shop.errors.NotEnoughStock;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "ITEM")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "categoryItems")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ITEM_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Item extends BaseEntity {

    @Builder
    public Item(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    private String name;

    private int price;

    private int stockQuantity;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<CategoryItem> categoryItems = new ArrayList<>();

    //==비즈니스 로직==//
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) throws NotEnoughStock {
        int removeStockResultQuantity = this.stockQuantity - quantity;
        if (removeStockResultQuantity < 0) {
            throw new NotEnoughStock();
        }
        this.stockQuantity = removeStockResultQuantity;
    }


}