package com.demowebshop.tests;
import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
        Configuration.baseUrl = "https://demowebshop.tricentis.com";
    }
}
