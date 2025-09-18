package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.mystore.base.BaseClass.getDriver;

public class HomePage extends BasePage {
    public HomePage() {
        super();
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
        Action.click(getDriver(), SignInButton);
//        return new LoginPage();
    }

    public boolean validateStoreLogo(){
        return Action.isDisplayed(getDriver(), myStoreLogo);
    }

    public String getStoreTitle(){
        return getDriver().getTitle();
    }

    public void searchProduct(String productName){
        Action.type(getDriver(), seachTextBox, productName);
        Action.click(getDriver(), searchButton);
//        return new SearchResultPage();
    }
}
