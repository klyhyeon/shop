package com.jpa.shop.domain;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}