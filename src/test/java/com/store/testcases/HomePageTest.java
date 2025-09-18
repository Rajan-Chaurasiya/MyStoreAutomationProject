package com.store.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    HomePage homePage;


    @Test
    public void validateLogo(){
        homePage = new HomePage();
        boolean result = homePage.validateStoreLogo();
        Assert.assertTrue(result);
    }

    @Test
    public void validateHomePageTitle(){
        homePage = new HomePage();
        String storeTitle = homePage.getStoreTitle();
        Assert.assertEquals(storeTitle, "My Shop");
    }
}
