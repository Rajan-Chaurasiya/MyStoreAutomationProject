package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage{
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id = 'center_column']//p[contains(text(), 'Your order on My Shop is complete.')]")
    WebElement orderConfirmMessage;

    public String orderConfirmText(){
        String confirmMessage = orderConfirmMessage.getText();
        return confirmMessage;
    }
}
