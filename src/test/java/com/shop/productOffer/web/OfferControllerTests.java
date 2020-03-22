package com.shop.productOffer.web;


import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shop.productOffer.AbstractTest;

public class OfferControllerTests extends AbstractTest {

    @Override
    @BeforeEach
    public void setUp(){
        super.setUp();
    }


    //POST request: Test for successful creation of an offer
    @Test
    public void successfulOfferCreation() throws Exception {
        String jsonString="{\"title\":\"furniture discount\"," +
                "\"description\":\"get 20% discount on furniture\"," +
                "\"validTill\":\"09/11/2020\"," +
                "\"discountPercent\":\"20\"," +
                "\"appliesTo\":\"furniture\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/offerlist/createoffer")
                .accept(MediaType.APPLICATION_JSON).content(jsonString)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(201, status);
        Assert.assertEquals( "offer has been created",content);
    }



    //POST request: Test for missing field  in the request body
    @Test
    public void OfferCreationMissingField() throws Exception {

        String jsonString="{\"title\":\"furniture discount\"," +
                "\"description\":get 20% discount on furniture," +
                "\"validTill\":09/11/2020," +
                "\"discountPercent\":20}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/offerlist/createoffer")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonString)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(400, status);
    }



    //GET request: Test case to check the response for Existing offer
    @Test
    public void checkGetOffer() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/offerlist/1")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        //Offer[] offerInfo = super.mapFromJson(content,Offer[].class);
        Assert.assertTrue(content.length()>0);
    }

    //GET request: Test case to check the response for non-existent offer
    @Test
    public void checkGetOfferNonExistent() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/offerlist/123")
                .accept(MediaType.TEXT_PLAIN_VALUE)).andReturn();
        System.out.println("mvcResult "+mvcResult.getResponse().getErrorMessage());
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("The Offer does not exist",content);
    }

    //GET request: Test case to check the response for expired offer
    @Test
    public void checkGetOfferExpired() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/offerlist/2")
                .accept(MediaType.TEXT_PLAIN_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(404, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("The offer has expired",content);
    }
}