package com.shop.productOffer.service;

import com.shop.productOffer.AbstractTest;
import com.shop.productOffer.domain.Category;
import com.shop.productOffer.domain.Offer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class OfferServiceTests extends AbstractTest {

    @Autowired
    OfferService offerService;

    @Test
    public void checkOfferCreation() throws ParseException {

        Offer offer1 = offerService.createOffer("yogurt discount","get 10% discount on all types of yogurts",
                new SimpleDateFormat("dd/MM/yyyy").parse("09/11/2001"),
                10.00, Category.food);
        Assert.assertSame(Offer.class,offer1.getClass());
    }
}
