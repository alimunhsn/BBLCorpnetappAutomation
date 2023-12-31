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
        getWebElement(By.cssSelector("div[class='w-full'] button[class='flex-c-m s2-txt2 size4 bg1 bor1 hov1 trans-04']")).click();
        return getInstance(HomePage.class);
    }

    public CorpnetLoginPage clickLoginBtnToFail() {
        getWebElement(By.cssSelector("div.w-full:nth-child(3)")).click();
        return this;
    }

      public HomePage doLogin(String username, String password) {
        return fillUsername(username)
                .fillPassword(password)
                .clickLoginBtn();
    }

    public boolean hasError() {
        return getWebElements(By.cssSelector("div[class='row'] label")).size() > 0;
    }
}
