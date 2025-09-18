package com.mystore.base;

import com.mystore.actiondriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.w3c.dom.DOMConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static Properties prop;
//    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseClass.class);

    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();


    public static WebDriver getDriver(){
        return driver.get();
    }

    @BeforeSuite
    public void beforeSuite() throws IOException {
        logger.info("===== Test Suite Execution Started =====");
        loadConfig();
    }

    @BeforeTest
    public static void loadConfig() throws IOException {

        try {
            prop = new Properties();
            System.out.println("super constructor invoked");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
            prop.load(ip);
            logger.info("Configuration file loaded successfully.");
        } catch (FileNotFoundException e){
            logger.error("Failed to load configuration file.", e);
            throw new RuntimeException("Configuration file not found", e);
        }

    }

    @BeforeMethod
    public void setup() {
        logger.info("===== Starting Test Setup =====");
        launchApp();
    }

    @AfterMethod
    public void tearDown() {
        logger.info("===== Closing Browser =====");
        getDriver().quit();
    }

    public static void launchApp(){

        String browserName = prop.getProperty("browser");
        logger.info("Launching application on browser: " +prop.getProperty("browser"));

        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
            // set Browser to ThreadLocalMaP
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.chromedriver().setup();
//            driver = new FirefoxDriver();
            // set Browser to ThreadLocalMaP
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.chromedriver().setup();
//            driver = new EdgeDriver();
            // set Browser to ThreadLocalMaP
            driver.set(new EdgeDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));

        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeOut"))));

        getDriver().get(prop.getProperty("url"));
        logger.info("Application launched successfully at: " + prop.getProperty("url"));

    }

    public String randomAlphaNumberic()
    {
        String generatedstring= RandomStringUtils.randomAlphabetic(3);
        String generatednumber=RandomStringUtils.randomNumeric(3);
        return (generatedstring+"."+generatednumber+"@gmail.com");
    }


}
