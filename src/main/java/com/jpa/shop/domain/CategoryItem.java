package com.jpa.shop.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CategoryItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    public void setCategory(Category category) {
        this.category = category;
        category.getCategoryItems().add(this);
    }

    public void setItem(Item item) {
        this.item = item;
        item.getCategoryItems().add(this);
    }
}