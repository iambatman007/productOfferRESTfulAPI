package com.shop.productOffer.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

public class Offer {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Date validTill;

    @Column
    private Float discountPercent;

    @Column
    private Category appliesTo;


    public Offer(String title, String description, Date validTill, Float discountPercent, Category appliesTo) {
        this.title = title;
        this.description = description;
        this.validTill = validTill;
        this.discountPercent = discountPercent;
        this.appliesTo = appliesTo;
    }

    public Boolean isOfferActive() {
        Date currentDate = new Date();
        return currentDate.before(validTill);
    }

    protected Offer() {
    }

    public Float getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Float discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Category getAppliesTo() {
        return appliesTo;
    }

    public void setAppliesTo(Category appliesTo) {
        this.appliesTo = appliesTo;
    }

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

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", validTill=" + validTill +
                ", discountPercent=" + discountPercent +
                ", appliesTo=" + appliesTo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return id.equals(offer.id) &&
                title.equals(offer.title) &&
                description.equals(offer.description) &&
                validTill.equals(offer.validTill) &&
                discountPercent.equals(offer.discountPercent) &&
                appliesTo == offer.appliesTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, validTill, discountPercent, appliesTo);
    }
}