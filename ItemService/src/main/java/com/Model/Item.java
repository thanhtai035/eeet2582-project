package com.Model;

import javax.persistence.*;

@Entity
@Table
public class Item {
    public enum Category {
        CPU, GPU, Ram, MainBoard, Case, SSD, PSU, VGA, Others
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long itemID;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double price;

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}