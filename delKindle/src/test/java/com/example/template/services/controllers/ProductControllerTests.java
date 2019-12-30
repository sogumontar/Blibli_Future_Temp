package com.example.template.services.controllers;


import com.example.template.model.Product;
import com.example.template.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTests {

    @Value("${local.server.port}")
    private int port;

    @MockBean
    private ProductService productService;
    private ObjectMapper mapper;

    @Before
    public void setup() {
        RestAssured.port = port;

        mapper = new ObjectMapper();
    }
    @After
    public void cleanup() {
        verifyNoMoreInteractions(productService);
    }

//    @Test
//    public void testFindFirstById() throws JsonProcessingException {
//        given()
//                .when()
//                .get("/product/get/21")
//                .then()
//                .body(equalTo(mapper.writeValueAsString(new Product())));
//    }


//    @Test
//    public String coba()



}
