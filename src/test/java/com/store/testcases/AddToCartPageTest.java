package com.store.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass {

    HomePage homePage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;


    @Test
    public void validateAddToCartTest(){

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

        Assert.assertTrue(addToCartPage.validateCheckOutMessage());

        addToCartPage.validateCheckOuntConfirmationButton();

    }
}
