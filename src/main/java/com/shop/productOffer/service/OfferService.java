package com.shop.productOffer.service;

import com.shop.productOffer.domain.Offer;
import com.shop.productOffer.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    @Autowired
    public OfferService (OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }

}
