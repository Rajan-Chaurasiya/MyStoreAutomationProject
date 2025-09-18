package com.store.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AccountPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;


    @Test
    public void validateMyAccount(){
        homePage = new HomePage();
        homePage.clickOnSignIn();

        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

        accountPage = new AccountPage();
        String expectedUrl = "http://www.automationpractice.pl/index.php?controller=my-account";
        String actualUrl = accountPage.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

        Assert.assertTrue(accountPage.ValidateMyAccount());

        Assert.assertTrue(accountPage.ValidateMyOrderHistory());

    }
}
