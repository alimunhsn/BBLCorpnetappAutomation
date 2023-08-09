package com.corpnet.testcases;

import com.corpnet.pages.BasePage;
import com.corpnet.pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest1 {
    public WebDriver driver;
    private Properties properties;
    public Page page;

    //public BaseTest() {
    //   try {
    //    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
    //  properties = new Properties();
    public BaseTest1() {
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
            properties = new Properties();
            FileInputStream inputStream = null;

            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @BeforeMethod
    public void setUpBrowser() {
        String browserName = properties.getProperty("browserName");
        //String browserName="firefox";

        if (browserName.equals("chrome")) {
            //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equals( "firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {
            System.out.println("Please provide proper Browser Name");
        }

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();
        page = new BasePage(driver);

    }


    @AfterMethod
    public void tearTown() {
        driver.quit();
    }
}