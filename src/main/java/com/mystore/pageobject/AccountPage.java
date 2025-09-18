package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{
    public AccountPage() {
        super();
    }


    @FindBy(xpath = "//span[normalize-space()='Order history and details']")
    WebElement myOrderHistory;

    @FindBy(xpath = "//h1[@class='page-heading']")
    WebElement myAccount;

    public boolean ValidateMyOrderHistory(){
        return Action.isDisplayed(driver, myOrderHistory);
    }

    public boolean ValidateMyAccount(){
        return Action.isDisplayed(driver, myAccount);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
