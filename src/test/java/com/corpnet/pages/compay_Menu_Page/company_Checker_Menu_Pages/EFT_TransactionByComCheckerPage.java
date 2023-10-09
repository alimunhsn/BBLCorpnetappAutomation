package com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class EFT_TransactionByComCheckerPage extends BasePage {
    public String iftBatchId;

    @FindBy(id = "idRejectButton")
    WebElement clickRejectBtnEl;

    @FindBy(css = "input#idRejectionReason")
    WebElement fillRejectReasonEl;

    @FindBy(id = "messageModalCancleTransactionYesAll")
    WebElement clickYesButtonEl;

    public EFT_TransactionByComCheckerPage(WebDriver driver) {
        super(driver);
    }


    public EFT_TransactionByComCheckerPage searchIFTBatchId(String iftID) throws InterruptedException {
        getWebElement(By.cssSelector("div label input.form-control-sm")).sendKeys(iftID);
        //iftBatchId = fillIftBatchIdEl.getText();
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + iftID);
        Thread.sleep(2000);
        return this;
    }


    public EFT_TransactionByComCheckerPage clickAuthorizeBtn() throws InterruptedException {
        getWebElement(By.cssSelector("tr[class='odd'] button[type='button']")).click();
        Thread.sleep(10000);
        return this;

    }

    public EFT_TransactionByComCheckerPage clickSubmitBtn() {
        getWebElement(By.id("idSubmitButton")).click();
        return this;

    }

    public EFT_TransactionByComCheckerPage clickRejectBtn() {
        getWebElement(By.id("idSubmitButton")).click();
        return this;

    }

    public EFT_TransactionByComCheckerPage fillRejectReason(String rejectReason) {
        fillRejectReasonEl.isDisplayed();
        clickRejectBtnEl.sendKeys(rejectReason);
        return this;

    }

    public boolean hasSingleTranAuthorizedSuccess() {
        return getWebElement(By.cssSelector("div[aria-modal='true'] div.modal-body p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.TranAuthTranComplete);
        // return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranAuthTranComplete);
        // return getWebElement(By.cssSelector("div.modal-body>p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.TranAuthTranComplete);

    }

    public boolean hasBulkTranAuthorizedSuccess() {
        // return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranAuthTranComplete);
        return getWebElement(By.cssSelector("div[aria-modal='true'] div.modal-body p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.TranAuthTranComplete);
    }


}




