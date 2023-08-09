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

public class BaseTest {
    WebDriver driver;
    private Properties properties;
    public Page page;

    //public BaseTest() {
    //   try {
    //    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
    //  properties = new Properties();
    public BaseTest() {
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
            properties = new Properties();
            FileInputStream inputStream = null;

            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @BeforeMethod
    public void setUpBrowser() {
        String browserName = properties.getProperty("browserName");
        //String browserName="firefox";

        if (Objects.equals(browserName, "chrome")) {
            //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (Objects.equals(browserName, "firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (Objects.equals(browserName, "chromeHeadless")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);

        } else if (Objects.equals(browserName, "firefoxHeadless")) {
            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else {
            System.out.println("Please provide proper Browser Name");
        }

        driver.get(properties.getProperty("baseUrl"));
        driver.manage().window().maximize();
        page = new BasePage(driver);
    }

    public String getOpsMakerUser() {
        return properties.getProperty("OpsMakerUser");
    }

    public String getOpsMakerPass() {
        return properties.getProperty("OpsMakerPass");
    }


    @AfterMethod
    public void tearTown() {
        driver.quit();
    }
}