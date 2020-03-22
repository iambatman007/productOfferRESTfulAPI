package com.shop.productOffer;

import com.shop.productOffer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.shop.productOffer.domain.Category;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ProductOfferApplication implements CommandLineRunner {

	@Autowired
	private OfferService offerService;

	public static void main(String[] args) {
		SpringApplication.run(ProductOfferApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		createOffers();
	}

	private void createOffers() throws ParseException {
		offerService.createOffer("shoes discount","get 50% discount on all shoes",
				new SimpleDateFormat("dd/MM/yyyy").parse("09/11/2020"),
				50.00,Category.apparel);


		offerService.createOffer("yogurt discount","get 10% discount on all types of yogurts",
				new SimpleDateFormat("dd/MM/yyyy").parse("09/11/2001"),
				10.00,Category.food);

	}
}
