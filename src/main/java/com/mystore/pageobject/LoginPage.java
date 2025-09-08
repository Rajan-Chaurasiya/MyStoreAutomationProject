package com.mystore.pageobject;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.XMLFormatter;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement email_textBox;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement password_textBox;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement sign_in_Button;

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement create_email_TextBox;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement create_email_Button;


    public void login(String username, String password){
        Action.type(driver,email_textBox, username);
        Action.type(driver, password_textBox, password);
        Action.click(driver, sign_in_Button);
    }

    public void createNewAccount(String create_username){
        Action.type(driver, create_email_TextBox, create_username);
        Action.click(driver, create_email_Button);
    }
}
