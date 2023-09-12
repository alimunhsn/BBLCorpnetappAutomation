package com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class IFT_TransactionByComCheckerPage extends BasePage {

    public IFT_TransactionByComCheckerPage(WebDriver driver) {
        super(driver);
    }


    public IFT_TransactionByComCheckerPage searchIFTSingleBatchId(String iftSingleBatchID) throws InterruptedException {
        getWebElement(By.cssSelector("input.form-control-sm")).sendKeys(iftSingleBatchID);
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + iftSingleBatchID);
        Thread.sleep(3000);
        return this;
    }

    public IFT_TransactionByComCheckerPage clickAuthorizeBtn() throws InterruptedException {
        getWebElement(By.cssSelector("tr[class='odd'] button[type='button']")).click();        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        Thread.sleep(10000);
        return this;

    }

    public IFT_TransactionByComCheckerPage clickSubmitBtn() throws InterruptedException {
        getWebElement(By.id("idSubmitButton")).click();
        Thread.sleep(5000);
        return this;

    }

    public boolean hasSingleTranAuthorizedSuccess() {
       return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranAuthTranComplete);
    }


}

