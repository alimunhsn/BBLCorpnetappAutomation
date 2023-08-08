package com.corpnet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTittle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By locator) {
        WebElement webElement = null;
        try {
            waitForWebElements(locator);
            webElement=driver.findElement(locator);

        } catch (Exception exception)
        {
            System.out.println(locator.toString()+ " Issues for WebElement");
        }
        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By locator) {
        List<WebElement> webElements= null;
        try {
            waitForWebElements(locator);
            webElements=driver.findElements(locator);

        }catch (Exception exception){
            System.out.println(locator.toString()+ " Issue for List of elements");
        }
        return webElements;
    }

    @Override
    public void waitForWebElements(By locator) {
        try
        {
          wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Exception exception)
        {
            System.out.println(locator.toString()+" Not loading");
        }

    }
}
