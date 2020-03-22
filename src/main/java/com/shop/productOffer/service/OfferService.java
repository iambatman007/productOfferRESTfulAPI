package com.shop.productOffer.service;

import com.shop.productOffer.domain.Category;
import com.shop.productOffer.domain.Offer;
import com.shop.productOffer.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    @Autowired
    public OfferService (OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }

    public Offer createOffer(String title, String description, Date validTill, Double discountPercent, Category appliesTo){
        return offerRepository.save(new Offer( title, description, validTill, discountPercent, appliesTo));
    }

}
