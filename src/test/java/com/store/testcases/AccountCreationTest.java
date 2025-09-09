package com.store.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AccountCreationPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LoginPage;
import org.apache.poi.xddf.usermodel.XDDFRelativeRectangle;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

public class AccountCreationTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;
    AccountCreationPage accountCreationPage;

    @BeforeMethod
    public void setUp(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void AccountCreationPageTest(){
        homePage = new HomePage(driver);
        homePage.clickOnSignIn();

        loginPage = new LoginPage(driver);
        String loginPageCurrentUrl = loginPage.getCurrentUrl();
        String ExpectedResult = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
        Assert.assertEquals(loginPageCurrentUrl, ExpectedResult);

        loginPage.createNewAccount(randomAlphaNumberic());

        accountCreationPage = new AccountCreationPage(driver);

        Assert.assertTrue(accountCreationPage.validateAccountCreatePage());

    }
}
