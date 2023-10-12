package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.RTGS_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;

public class RTGS_SingleTransactionByComMakerPage extends BasePage {

    public String SingleIftBatch;

    public RTGS_SingleTransactionByComMakerPage(WebDriver driver) {
        super(driver);
    }

    public RTGS_SingleTransactionByComMakerPage selectBeneficiary(int index) {
        new Select(getWebElement(By.id("beneficiary"))).selectByIndex(index);
        return this;
    }

    public RTGS_SingleTransactionByComMakerPage fillAmount(String remarks) {
        getWebElement(By.id("trxAmount")).sendKeys(remarks);
        return this;

    }

    public RTGS_SingleTransactionByComMakerPage fillRemarks(String remarks) throws InterruptedException {

        getWebElement(By.id("trxRemarks")).sendKeys(remarks);
        Thread.sleep(1000);
        return this;

    }

    public RTGS_SingleTransactionByComMakerPage nextButton() {

        getWebElement(By.cssSelector("button[type='submit']")).click();
        return this;
    }

    public RTGS_SingleTransactionByComMakerPage confirmButton() throws FileNotFoundException {
        SingleIftBatch = getWebElement(By.id("transactionReference")).getAttribute("value");
        getWebElement(By.cssSelector("button[name='submit']")).click();
        return this;
    }
    public boolean hasSingleRTGS_TranInitiatedSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
    }


}

