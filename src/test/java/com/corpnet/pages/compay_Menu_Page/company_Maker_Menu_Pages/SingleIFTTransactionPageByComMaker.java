package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages;

import com.corpnet.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SingleIFTTransactionPageByComMaker extends BasePage {

    public String SingleIftBatch;


    public SingleIFTTransactionPageByComMaker(WebDriver driver) {
        super(driver);
    }


    public SingleIFTTransactionPageByComMaker selectComAcc(int index) {
        WebElement webElement = getWebElement(By.id("companyAccount"));
        new Select(webElement).selectByIndex(index);
        return this;
    }

    public SingleIFTTransactionPageByComMaker selectBeneficiary(int index) {
        WebElement webElement = getWebElement(By.id("beneficiary"));
        new Select(webElement).selectByIndex(index);
        return this;
    }

    public SingleIFTTransactionPageByComMaker fillTrxAmount() {
        WebElement webElement = getWebElement(By.id("trxAmount"));
        webElement.sendKeys("50000.35");
        return this;

    }

    public SingleIFTTransactionPageByComMaker fillTrxRemarks() throws InterruptedException {
        WebElement webElement = getWebElement(By.id("trxRemarks"));
        webElement.sendKeys("IFT_Single_Transaction");
        Thread.sleep(1000);
        return this;

    }

    public SingleIFTTransactionPageByComMaker clickNextBtn() {
        WebElement webElement = getWebElement(By.cssSelector("button[class='btn btn-primary'][type='submit']"));
        webElement.click();
        return this;
    }

    public SingleIFTTransactionPageByComMaker clickConfirmBtn() throws InterruptedException {
        WebElement webElement= getWebElement(By.id("transactionReference"));
        webElement.isDisplayed();
        //SingleIftBatch=getIftSingleRefEl.getText();
        SingleIftBatch = webElement.getAttribute("value");
        Thread.sleep(3000);
        return this;
    }


}
