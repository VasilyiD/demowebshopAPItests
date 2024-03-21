package com.demowebshop.tests;
import com.demowebshop.helpers.CustomApiListener;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

import org.openqa.selenium.Cookie;

public class DemowebshopTests extends BaseTest {


    static String login = "myfirst@gmail.com",
            password = "qwerty";

    @BeforeEach
    @Test
    @Tag("demowebshop")
    @DisplayName("Successful authorization to demowebshop (API + UI)")
    void loginWithCookieTest() {
        step("Get cookie by api and set it to browser", () -> {
            String authorizationCookie =
                    given()
                            .filter(CustomApiListener.withCustomTemplates())
                            .formParam("Email", login)
                            .formParam("Password", password)
                            .formParam("RememberMe", false)
                            .when()
                            .post("/login")
                            .then()
                            .statusCode(302)
                            .extract()
                            .cookie("NOPCOMMERCE.AUTH");

            step("Open minimal content, because cookie can be set when site is opened", () ->
                    open("/Themes/DefaultClean/Content/images/logo.png"));

            step("Set cookie to to browser", () ->
                    getWebDriver().manage().addCookie(
                            new Cookie("NOPCOMMERCE.AUTH", authorizationCookie)));
        });

/*        step("Open main page", () ->
                open(""));

        step("Verify successful authorization", () ->
                $(".account").shouldHave(text(login)));*/
    }

    @Test
    @Tag("demowebshop")
    @DisplayName("Successful adding to cart by authorized user at demowebshop")
    void addToCartTest() {

        String body = "product_attribute_16_5_4=14&product_attribute_16_6_5=15&product_attribute_16_3_6=19&" +
                "product_attribute_16_4_7=44&product_attribute_16_8_8=22&addtocart_16.EnteredQuantity=1";

        step("Add to cart product", () -> {

        });
    }



}
