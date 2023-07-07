package com.example.unittesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class Item {
    @Id
    private int id;
    private String name;
    private int price;
    private int quantity;

    @Transient
    private int value;


    public Item(int id, String name, int price, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item() {

    }

    public String toString(){
        return String.format("Item[%d, %s, %d, %d]", id, name, price,quantity);
    }
}
