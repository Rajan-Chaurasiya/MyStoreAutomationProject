package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage{
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='price special-price']")
    WebElement unitPrice;

    @FindBy(xpath = "//span[@id='total_price']")
    WebElement totalPrice;

    @FindBy(xpath = "//td[@id='total_shipping']")
    WebElement totalShipping;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement checkOut;

    public double unitPrice(){

        String unitPriceString = unitPrice.getText();
        String unit = unitPriceString.replaceAll("[^a-zA-Z0-9]","");
        double finalUnitPrice = Double.parseDouble(unit);
        return finalUnitPrice/100;
    }

    public double totalPrice(){
        String totalPriceString = totalPrice.getText();
        String finalPrice = totalPriceString.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice = Double.parseDouble(finalPrice);
        return finalTotalPrice/100 + unitPrice();

    }
}
