package com.corpnet.pages.operations_Checker_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnauthorizedCompaniesByCheckerPage extends BasePage {



    public UnauthorizedCompaniesByCheckerPage(WebDriver driver) {
        super(driver);
    }

    public UnauthorizedCompaniesByCheckerPage companySearch(String companyName)
    {
        getWebElement(By.cssSelector("div[id='dataTables-example_filter'] label input[type='search']"))
                .sendKeys(companyName);
        return this;
    }

    public UnauthorizedCompaniesByCheckerPage clickDetailsBtn() {
        getWebElement(By.cssSelector("div tr td a[class ='btn btn-success']")).click();
        return this;


    }

    public UnauthorizedCompaniesByCheckerPage clickSubBtn() {
        getWebElement(By.id("submitButton")).click();
        return this;

    }

    public boolean hasNewCompanyAuthorizeSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        //return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
        return getWebElement(By.cssSelector("div.modal-body>p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.NewComAuthorizeComplete);
    }

}
