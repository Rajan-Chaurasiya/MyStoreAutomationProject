package com.store.testcases;

import com.mystore.actiondriver.Action;
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

public class SearchResultPageTest extends BaseClass {

    HomePage homePage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;

    @BeforeMethod
    public void setUp(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void validateSearchResultPage(){

        homePage = new HomePage(driver);
        homePage.searchProduct("Printed Summer Dress");

        searchResultPage = new SearchResultPage(driver);
        searchResultPage.ScrollOverProductByPixel();
        Assert.assertTrue(searchResultPage.isProductAvailable());



    }
}
