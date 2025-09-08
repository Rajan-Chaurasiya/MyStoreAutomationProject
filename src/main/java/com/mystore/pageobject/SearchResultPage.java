package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//img[@title='Printed Summer Dress'])[2]")
    WebElement productResult;



    public boolean isProductAvailable(){
        return Action.isDisplayed(driver, productResult);
    }

    public void clickOnProduct(){
        Action.click(driver, productResult);
    }


}
