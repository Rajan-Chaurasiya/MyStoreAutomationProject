package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends BasePage{
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='cgv']")
    WebElement shippingCheck;

    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    WebElement shippingCheckButton;

    public void shippingClick(){
        Action.click(driver, shippingCheck);
    }

    public void shippingCheckOut(){
        Action.click(driver, shippingCheckButton);
    }
}
