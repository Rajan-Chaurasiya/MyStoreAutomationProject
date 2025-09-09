package com.store.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPageTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginTest(){

        homePage = new HomePage(driver);
        homePage.clickOnSignIn();

        loginPage = new LoginPage(driver);

        String loginPageCurrentUrl = loginPage.getCurrentUrl();
        String ExpectedResult = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
        Assert.assertEquals(loginPageCurrentUrl, ExpectedResult);

        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
}
