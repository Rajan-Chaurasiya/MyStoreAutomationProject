package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//img[@title='Printed Summer Dress'])[1]")
    WebElement productResult;

    @FindBy(xpath = "//div[@class='bottom-pagination-content clearfix']//div[@class='product-count'][normalize-space()='Showing 1 - 3 of 3 items']")
    WebElement pageCountFooter;



    public boolean isProductAvailable(){
        return Action.isDisplayed(driver, productResult);
    }

    public void clickOnProduct(){
        Action.click(driver, productResult);
    }

    public void waitforElement(){
        Action.scrollByVisibilityOfElement(driver, pageCountFooter);
    }

    public void HoverOverProduct(){
        Action.mouseHover(driver, productResult);
    }

    public void ScrollOverProductByPixel(){
        Action.scrollByPixel(driver, 0, 400);
    }



}
