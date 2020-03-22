package com.shop.productOffer.service;

import com.shop.productOffer.domain.Category;
import com.shop.productOffer.domain.Offer;
import com.shop.productOffer.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    public Offer createOffer(String title, String description, Date validTill, Double discountPercent, Category appliesTo) {
        return offerRepository.save(new Offer(title, description, validTill, discountPercent, appliesTo));
    }

    public void deleteOffer(Integer Id) {
        Offer validOffer = offerRepository.findById(Id).orElseThrow(() ->
                new NoSuchElementException("The Offer does not exist"));

        Date expiryDate = validOffer.getValidTill();
        Date currentDate = new Date();
        if (currentDate.before(expiryDate)) {
                offerRepository.deleteById(Id);
        } else{
            throw new NoSuchElementException("The offer has expired");
        }
    }
}
