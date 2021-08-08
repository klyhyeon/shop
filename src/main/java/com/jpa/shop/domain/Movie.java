package com.jpa.shop.domain;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Movie")
@Getter
public class Movie extends Item {

    private String director;

    private String actor;
}
