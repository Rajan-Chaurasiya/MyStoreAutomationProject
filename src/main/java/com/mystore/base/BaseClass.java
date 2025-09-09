package com.mystore.base;

import com.mystore.actiondriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;
    public static WebDriver driver;

    @BeforeTest
    public static void loadConfig() throws IOException {

        try {
            prop = new Properties();
            System.out.println("super constructor invoked");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void launchApp(){
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.chromedriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.chromedriver().setup();
            driver = new EdgeDriver();
        }

        Action.implicitWait(driver);
        driver.manage().deleteAllCookies();
        Action.pageLoadTimeOut(driver);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));


    }

    public String randomAlphaNumberic()
    {
        String generatedstring= RandomStringUtils.randomAlphabetic(3);
        String generatednumber=RandomStringUtils.randomNumeric(3);
        return (generatedstring+"."+generatednumber+"@gmail.com");
    }


}
