package com.shop.productOffer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name ="Offer")
public class Offer {

    @Id
    @GeneratedValue
    private Integer OfferId;

    @Column
    @Size(min = 3 , max =30)
    private String title;

    @Column
    @Size(min = 3 , max =100)
    private String description;

    @Column
    private Date validTill;

    @Column
    @DecimalMax("70.00")
    private Double discountPercent;

    @Column
    private Category appliesTo;


    public Offer(String title, String description, Date validTill, Double discountPercent, Category appliesTo) {
        this.title = title;
        this.description = description;
        this.validTill = validTill;
        this.discountPercent = discountPercent;
        this.appliesTo = appliesTo;
    }



    protected Offer() {
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Category getAppliesTo() {
        return appliesTo;
    }

    public void setAppliesTo(Category appliesTo) {
        this.appliesTo = appliesTo;
    }

    public Integer getOfferId() {
        return OfferId;
    }

    public void setOfferId(Integer offerId) {
        this.OfferId = offerId;
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
                /*"id=" + OfferId +*/
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
        return OfferId.equals(offer.OfferId) &&
                title.equals(offer.title) &&
                description.equals(offer.description) &&
                validTill.equals(offer.validTill) &&
                discountPercent.equals(offer.discountPercent) &&
                appliesTo == offer.appliesTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(OfferId, title, description, validTill, discountPercent, appliesTo);
    }
}