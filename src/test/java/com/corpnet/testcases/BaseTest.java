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

    public String getTranMCUser() {
        return properties.getProperty("TranMCUser");
    }

    public String getTranMCUserPass() {
        return properties.getProperty("TranMCUserPass");
    }

    public String getTranCompAppUser() {
        return properties.getProperty("CompAppUser");
    }

    public String getTranCompAppUserPass() {
        return properties.getProperty("CompAppUserPass");
    }

    // ############ Payroll Transaction Users Configuration ###############
    public String getMakerPayrollUser() {
        return properties.getProperty("MakerPayrollUser");
    }

    public String getCheckerPayrollUser() {
        return properties.getProperty("CheckerPayrollUser");
    }

    public String getApprovePayrollUser() {
        return properties.getProperty("ComAppPayrollUser");
    }


    //########## _______User & Password Configure--#####################
    public String getPayrollPassword() {
        return properties.getProperty("PayrollPassword");
    }

    public String getTransactionTracker() {
        return properties.getProperty("transactionTracker");

    }


    //-----------########## IFT Bulk File Configure---##############
    public String getIFTSingleBulkFile() {
        return properties.getProperty("IFTSingleBulk");

    }

    public String getIFTMultipleBulkFile() {
        return properties.getProperty("IFTMultipleBulk");

    }

    public String getPayrollBulkBulkFile() {
        return properties.getProperty("PayrollBulk");

    }

    //--####### EFT Bulk File Configure---##############
    public String getEFTSingleBulkFile() {
        return properties.getProperty("EFTSingleBulk");

    }

    public String getEFTMultipleBulkFile() {
        return properties.getProperty("EFTMultipleBulk");

    }

    public String getRTGSBulkFile() {
        return properties.getProperty("RTGSBulk");

    }

    public String getSpAuthMakerUser() {
        return properties.getProperty("SpAuthMakerUser");

    }    public String getSpAuthCheckerUser() {
        return properties.getProperty("SpAuthCheckerUser");

    }   public String getSpAuthSingApproveUser() {
        return properties.getProperty("SpAuthSingApproveUser");

    }

    public String getSpAuthMakerUserPass() {
        return properties.getProperty("SpAuthMakerUserPass");

    }

    public int getSelectAccount() {
        return 0;

        //  return properties.getProperty("selectAccount");

    }


    @AfterMethod
    public void tearTown() {
        driver.quit();
    }
}