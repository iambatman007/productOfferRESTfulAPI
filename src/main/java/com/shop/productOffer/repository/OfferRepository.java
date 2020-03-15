package com.shop.productOffer.repository;

import org.springframework.data.repository.CrudRepository;
import com.shop.productOffer.domain.Offer;

public interface OfferRepository extends CrudRepository<Offer, Integer> {

}
