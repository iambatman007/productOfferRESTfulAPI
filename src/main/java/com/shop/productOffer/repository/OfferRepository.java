package com.shop.productOffer.repository;

import org.springframework.data.repository.CrudRepository;
import com.shop.productOffer.domain.Offer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "offerList", path = "offerlist")
public interface OfferRepository extends CrudRepository<Offer, Integer> {




}
