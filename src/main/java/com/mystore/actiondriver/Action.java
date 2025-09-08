package com.mystore.actiondriver;

import com.mystore.base.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Action extends BaseClass {

    public static final int TimeOut = 10;


    //Explicit wait
    public static WebElement waitForElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(TimeOut));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //implicit wait
    public static void implicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeOut));
    }

    //pageloadtimeout
    public static void pageLoadTimeOut(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    // click method
    public static void click(WebDriver driver,WebElement element){
       try {
           waitForElement(driver, element).click();
           System.out.println("Clicked on element "+ element);
       }catch (Exception e){
           System.out.println("Click failed, trying JS Click... "+e.getMessage());
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].click();", element);
       }
    }

    public static void type(WebDriver driver, WebElement element,String text){

        try {
            WebElement el = waitForElement(driver, element);
            el.clear();
            el.sendKeys(text);
            System.out.println("Typed: " + text);
        }catch (Exception e){
            throw new RuntimeException("Unable to type into element: "+ element, e);
        }

    }

    public static String getText(WebDriver driver, WebElement element){

        return waitForElement(driver, element).getText();

    }

    public static void selectByVisibleText(WebDriver driver, WebElement element, String value){

        Select select = new Select(waitForElement(driver, element));
        select.selectByVisibleText(value);
    }

    public static void selectByValue(WebDriver driver, WebElement element, String value){

        Select select = new Select(waitForElement(driver, element));
        select.selectByValue(value);
    }

    public static void selectByIndex(WebDriver driver, WebElement element, int index){

        Select select = new Select(waitForElement(driver, element));
        select.selectByIndex(index);
    }

    //mouse hover
    public static void mouseHover(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(waitForElement(driver, element)).perform();
    }

    //Double Click
    public static void doubleClick(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.doubleClick(waitForElement(driver, element)).perform();
    }

    // Right Click
    public static void rightClick(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.contextClick(waitForElement(driver, element)).perform();
    }


    //Scroll by visiblity element
    public static void scrollByVisibilityOfElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public static boolean findElement(WebDriver driver, WebElement element){

        boolean flag = false;
        try {
            element.isDisplayed();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }finally {
            if (flag){
                System.out.println("Successfully found the element at");
            }else {
                System.out.println("Unable to locate the element at");
            }
        }
        return flag;
    }

    // check if element is displayed
    public static boolean isDisplayed(WebDriver driver, WebElement element){

        try {
            return waitForElement(driver, element).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public static boolean isSelected(WebDriver driver, WebElement element){
        try {
            return waitForElement(driver, element).isSelected();
        }catch (NoSuchElementException | TimeoutException e){
            return false;
        }
    }

    public static boolean isEnabled(WebDriver driver, WebElement element){
        try {
            return waitForElement(driver, element).isEnabled();
        }catch (NoSuchElementException | TimeoutException e){
            return false;
        }
    }

    public static void acceptAlert(WebDriver driver){

        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public static String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    // Switch to frame
    public static void switchToFrame(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }



}
