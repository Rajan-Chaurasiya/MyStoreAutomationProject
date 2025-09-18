package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.mystore.base.BaseClass.getDriver;


public class BasePage {

    protected WebDriver driver;

    public BasePage(){
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }
}
