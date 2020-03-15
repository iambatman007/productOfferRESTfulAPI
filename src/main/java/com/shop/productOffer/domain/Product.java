package com.shop.productOffer.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Float price;

    @Column
    @Enumerated
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                title.equals(product.title) &&
                description.equals(product.description) &&
                price.equals(product.price) &&
                category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, category);
    }
}
