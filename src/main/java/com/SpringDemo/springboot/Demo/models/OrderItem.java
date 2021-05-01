package com.SpringDemo.springboot.Demo.models;


import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "orderitem")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private int ordersItemId;

    @NotBlank(message = "Name is mandatory")
    private String items;

    private int quantity;
    private int price;

    public OrderItem() {
    }

    public OrderItem(String items, int quantity, int price, int ordersItemId) {
        this.ordersItemId = ordersItemId;
        this.items = items;
        this.quantity = quantity;
        this.price = price;
    }


}
