package com.store.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {

    HomePage homePage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;


    @Test
    public void verifyTotalPrice(){

        homePage = new HomePage();
        homePage.searchProduct("Printed Summer Dress");

        searchResultPage = new SearchResultPage();
        searchResultPage.ScrollOverProductByPixel();
        searchResultPage.HoverOverProduct();
        searchResultPage.clickOnProduct();

        addToCartPage = new AddToCartPage();
        addToCartPage.selectSize(1);
        addToCartPage.selectColor();
        addToCartPage.SelectQuanity("2");
        addToCartPage.selectAddToCart();
        addToCartPage.validateCheckOuntConfirmationButton();

        orderPage = new OrderPage();
        double unitprice = orderPage.unitPrice();
        double totalprice = orderPage.totalPrice();
        double totalExpectedPrice = (unitprice*2) + 7;

//        System.out.println(unitprice);
//        System.out.println(totalprice);
//        System.out.println(totalExpectedPrice);
        Assert.assertEquals(orderPage.totalPrice(),totalExpectedPrice);


    }
}
