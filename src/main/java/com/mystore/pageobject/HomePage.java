package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement seachTextBox;

    @FindBy(xpath = "//button[@name='submit_search']")
    WebElement searchButton;

    @FindBy(xpath = "//img[@alt='My Shop']")
    WebElement myStoreLogo;

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement SignInButton;

    public void clickOnSignIn(){
        Action.click(driver, SignInButton);
//        return new LoginPage();
    }

    public boolean validateStoreLogo(){
        return Action.isDisplayed(driver, myStoreLogo);
    }

    public String getStoreTitle(){
        return driver.getTitle();
    }

    public void searchProduct(String productName){
        Action.type(driver, seachTextBox, productName);
        Action.click(driver, searchButton);
//        return new SearchResultPage();
    }
}
