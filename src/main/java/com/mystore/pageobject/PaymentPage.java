package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    WebElement PaymentByBankWire;

    @FindBy(xpath = "//a[@title='Pay by check.']")
    WebElement PaymentByCheque;

    public void payWithBank(){
        Action.click(driver,PaymentByBankWire);
    }

}
