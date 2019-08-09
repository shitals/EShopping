package com.ss.eshopping.product.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @Column(unique = true)
    @JsonProperty("id")
    private Long id;
    @Column
    @JsonProperty ("name")
    private String name;

    @Column
    @JsonProperty ("category")
    private String category;

    @Column
    @JsonProperty("retail_price")
    private Double retailPrice;

    @Column
    @JsonProperty("discounted_price")
    private Double discountedPrice;

    @Column
    @JsonProperty ("availability")
    private Boolean availability;

    public Product() {
    }

    public Product(Long id, String name, String category, Double retailPrice, Double discountedPrice, Boolean availability) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.retailPrice = retailPrice;
        this.discountedPrice = discountedPrice;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", retailPrice=" + retailPrice +
                ", discountedPrice=" + discountedPrice +
                ", availability=" + availability +
                '}';
    }
}
