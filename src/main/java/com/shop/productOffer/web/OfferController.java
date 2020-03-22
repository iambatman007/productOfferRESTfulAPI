package com.shop.productOffer.web;


import com.shop.productOffer.domain.Category;
import com.shop.productOffer.domain.Offer;
import com.shop.productOffer.repository.OfferRepository;
import com.shop.productOffer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.NoSuchElementException;


@RestController
@RequestMapping(path = "/offerlist")
public class OfferController {
    OfferRepository offerRepository;
    OfferService offerService;

    @Autowired
    public OfferController(OfferRepository offerRepository, OfferService offerService) {
        this.offerRepository = offerRepository;
        this.offerService = offerService;
    }

    protected OfferController() {
    }

    @RequestMapping(path="/{id}")
    public Offer getOffer(@PathVariable("id") Integer offerId) throws NoSuchElementException {
        Offer validOffer = offerRepository.findById(offerId).orElseThrow(() ->
                new NoSuchElementException("The Offer does not exist"));

        Date expiryDate = validOffer.getValidTill();
        Date currentDate = new Date();
        if(expiryDate.before(currentDate)){
            throw new NoSuchElementException("The offer has expired");
        } else{
            return offerRepository.findById(offerId).orElseThrow(() ->
                    new NoSuchElementException("The Offer does not exist : " + offerId));
        }
    }

    @RequestMapping(path="/delete/{id}")
    public void deleteOffer(@PathVariable("id") Integer OfferId){
        offerService.deleteOffer(OfferId);
    }

    @RequestMapping(path="/createoffer", method = RequestMethod.POST)
    public ResponseEntity createAnOffer(@RequestBody  Map<String, String> payload) throws ParseException {


            offerService.createOffer(payload.get("title"), payload.get("description"),
                    new SimpleDateFormat("dd/MM/yyyy").parse(payload.get("validTill")),
                    Double.parseDouble(payload.get("discountPercent")),
                    Category.valueOf(payload.get("appliesTo")));


        return new ResponseEntity("offer has been created",HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String retun400(NoSuchElementException ex){
        return ex.getMessage();
    }
}
