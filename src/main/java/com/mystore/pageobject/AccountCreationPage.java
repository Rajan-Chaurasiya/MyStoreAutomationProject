package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.cert.X509Certificate;

public class AccountCreationPage extends BasePage{
    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Create an account']")
    WebElement formTitle;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement gender;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement password;


    public boolean validateAccountCreatePage(){
        return Action.isDisplayed(driver, formTitle);
    }

}
