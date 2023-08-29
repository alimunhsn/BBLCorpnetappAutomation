package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SingleIFTTransactionByComMakerPage extends BasePage {

    public String SingleIftBatch;


    public SingleIFTTransactionByComMakerPage(WebDriver driver) {
        super(driver);
    }


    public SingleIFTTransactionByComMakerPage selectComAcc(int index) {
        WebElement webElement = getWebElement(By.id("companyAccount"));
        new Select(webElement).selectByIndex(index);
        return this;
    }

    public SingleIFTTransactionByComMakerPage selectBeneficiary(int index) {
        WebElement webElement = getWebElement(By.id("beneficiary"));
        new Select(webElement).selectByIndex(index);
        return this;
    }

    public SingleIFTTransactionByComMakerPage fillTrxAmount() {
        WebElement webElement = getWebElement(By.id("trxAmount"));
        webElement.sendKeys("50000.35");
        return this;

    }

    public SingleIFTTransactionByComMakerPage fillTrxRemarks() throws InterruptedException {
        WebElement webElement = getWebElement(By.id("trxRemarks"));
        webElement.sendKeys("IFT_Single_Transaction");
        Thread.sleep(1000);
        return this;

    }

    public SingleIFTTransactionByComMakerPage clickNextBtn() throws InterruptedException {
        WebElement webElement = getWebElement(By.cssSelector("button[class='btn btn-primary'][type='submit']"));
        webElement.click();
        Thread.sleep(6000);
        return this;
    }

    public SingleIFTTransactionByComMakerPage getIftTranRef() throws InterruptedException {
        WebElement webElement = getWebElement(By.id("transactionReference"));
        SingleIftBatch = webElement.getAttribute("value");
        return this;
    }

    public SingleIFTTransactionByComMakerPage clickConfirmBtn() throws InterruptedException {
        SingleIftBatch= getWebElement(By.id("transactionReference")).getAttribute("value");
        //WebElement webElement = getWebElement(By.id("transactionReference"));
       // SingleIftBatch = webElement.getAttribute("value");
        Thread.sleep(3000);
        getWebElement(By.cssSelector("button#uploadBtn")).click();
        Thread.sleep(3000);
        return this;
    }

    public boolean hasSingleTranInitiatedSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
    }


}
