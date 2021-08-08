package com.jpa.shop.domain;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
@Getter
public class Book extends Item {

    private String author;

    private String isbn;
}
