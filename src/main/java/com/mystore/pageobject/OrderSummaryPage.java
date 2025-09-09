package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPage extends BasePage{
    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[normalize-space()='I confirm my order']")
    WebElement orderSummaryButton;

    @FindBy(xpath = "//p[contains(text(),'I confirm my order')]")
    WebElement orderConfirmMessage;

    public void clickOnOrderSummaryButton(){
        Action.click(driver, orderSummaryButton);
    }

    public void validateConfirmMessage(){
        Action.isDisplayed(driver,orderConfirmMessage);
    }
}
