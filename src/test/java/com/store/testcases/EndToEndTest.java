package com.store.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {

    HomePage homePage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;
    LoginPage loginPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    OrderSummaryPage orderSummaryPage;
    OrderConfirmationPage orderConfirmationPage;


    @Test
    public void endToEndTest(){

        homePage = new HomePage();
        homePage.searchProduct("Printed Summer Dress");

        searchResultPage = new SearchResultPage();
        searchResultPage.ScrollOverProductByPixel();
        searchResultPage.HoverOverProduct();
        searchResultPage.clickOnProduct();

        addToCartPage = new AddToCartPage();
        addToCartPage.selectSize(1);
        addToCartPage.selectColor();
//        addToCartPage.SelectQuanity("2");
        addToCartPage.selectAddToCart();
        addToCartPage.validateCheckOuntConfirmationButton();

        orderPage = new OrderPage();
        orderPage.clickCheckOutSummary();

        loginPage = new LoginPage();
        loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));

        addressPage = new AddressPage();
        addressPage.clickAddressCheckout();

        shippingPage = new ShippingPage();
        shippingPage.shippingClick();
        shippingPage.shippingCheckOut();

        paymentPage = new PaymentPage();
        paymentPage.payWithBank();

        orderSummaryPage = new OrderSummaryPage();
        orderSummaryPage.validateConfirmMessage();
        orderSummaryPage.clickOnOrderSummaryButton();

        orderConfirmationPage = new OrderConfirmationPage();
        String actualString = orderConfirmationPage.orderConfirmText();
        String expectedString = "Your order on My Shop is complete.";

        Assert.assertEquals(actualString, expectedString);
    }
}
