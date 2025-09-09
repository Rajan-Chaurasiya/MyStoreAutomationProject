package com.store.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {

    HomePage homePage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;
    LoginPage loginPage;

    @Test
    public void endToEndTest(){

        homePage = new HomePage(driver);
        homePage.searchProduct("Printed Summer Dress");

        searchResultPage = new SearchResultPage(driver);
        searchResultPage.ScrollOverProductByPixel();
        searchResultPage.HoverOverProduct();
        searchResultPage.clickOnProduct();

        addToCartPage = new AddToCartPage(driver);
        addToCartPage.selectSize(1);
        addToCartPage.selectColor();
        addToCartPage.SelectQuanity("2");
        addToCartPage.selectAddToCart();
        addToCartPage.validateCheckOuntConfirmationButton();

        orderPage = new OrderPage(driver);
        orderPage.clickCheckOutSummary();

        loginPage = new LoginPage(driver);
        loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
    }
}
