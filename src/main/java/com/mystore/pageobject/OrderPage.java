package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage{
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='price special-price']")
    WebElement unitPrice;

    @FindBy(xpath = "//input[@name='quantity_5_24_0_0']")
    WebElement unitPriceSummary;

    @FindBy(xpath = "//span[@id='total_product_price_5_24_0']")
    WebElement totalPrice;

    @FindBy(xpath = "//td[@id='total_shipping']")
    WebElement totalShipping;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement checkOut;

    public double unitPrice(){

        String unitPriceString = unitPrice.getText();
        String unit = unitPriceString.replaceAll("[^a-zA-Z0-9]","");
        double finalUnitPrice = Double.parseDouble(unit);
        return finalUnitPrice;
    }

    public double totalPrice(){
        String totalPriceString = totalPrice.getText();
        String finalPrice = totalPriceString.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice = Double.parseDouble(finalPrice);
        return finalTotalPrice + 7;

    }

    public double unitPriceSummary(){
        String unitPriceString = unitPriceSummary.getText();
        String finalUnitPriceString = unitPriceString.replaceAll("[^a-zA-Z0-9]","");
        double final_unitPrice = Double.parseDouble(finalUnitPriceString);
        return final_unitPrice;
    }

    public void clickCheckOutSummary(){
        Action.click(driver, checkOut);
    }
}
