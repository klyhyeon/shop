package com.jpa.shop.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Table(name = "ITEM")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item {
}