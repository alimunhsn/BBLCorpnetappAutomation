package com.corpnet.pages.loginPages;

import com.corpnet.pages.BasePage;
import com.corpnet.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CorpnetLoginPage extends BasePage {

    public CorpnetLoginPage(WebDriver driver) {
        super(driver);
    }

    public CorpnetLoginPage fillUsername(String username) {
        WebElement webElement = getWebElement(By.id("user2"));
        webElement.clear();
        webElement.sendKeys(username);
        return this;
    }

    public CorpnetLoginPage fillPassword(String password) {
        getWebElement(By.id("pass2")).sendKeys(password);
        return this;
    }

    public HomePage clickLoginBtn() {
        getWebElement(By.cssSelector("div.w-full:nth-child(3)")).click();
        return getInstance(HomePage.class);
    }

    public CorpnetLoginPage clickLoginBtnToFail() {
        getWebElement(By.cssSelector("div.w-full:nth-child(3)")).click();
        return this;
    }

    public CorpnetLoginPage doLogin() {
        return clickLoginBtnToFail();
    }

    public CorpnetLoginPage doLogin(String username) {
        return fillUsername(username)
                .clickLoginBtnToFail();
    }

    public HomePage doLogin(String username, String password) {
        return fillUsername(username)
                .fillPassword(password)
                .clickLoginBtn();
    }

    public boolean hasError() {
        return getWebElements(By.className("error")).size() > 0;
    }
}
