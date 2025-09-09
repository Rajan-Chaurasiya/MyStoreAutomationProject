package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BasePage{
    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement selectQuanity;

    @FindBy(xpath = "//select[@id='group_1']")
    WebElement selectSizeElement;

    @FindBy(xpath = "//a[@id='color_14']")
    WebElement selectColor;

    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCart;

    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement checkMessage;

    @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
    WebElement checkOutConfirmed;


    public void SelectQuanity(String quanity){
        Action.type(driver, selectQuanity, quanity);
    }

    public void selectSize(int size){
        Action.selectByIndex(driver,selectSizeElement, 1);
    }

    public void selectColor(){
        Action.click(driver, selectColor);
    }

    public void selectAddToCart(){
        Action.click(driver, addToCart);
    }

    public boolean validateCheckOutMessage(){
        return Action.isDisplayed(driver, checkMessage);
    }

    public void validateCheckOuntConfirmationButton(){
        Action.click(driver, checkOutConfirmed);
    }
}
