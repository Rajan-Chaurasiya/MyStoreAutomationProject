package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage{
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    WebElement adderessCheck;

    public void clickAddressCheckout(){
        Action.click(driver, adderessCheck);
    }
}
