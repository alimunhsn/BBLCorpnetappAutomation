package com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages;
import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class RTGS_BulkTransactionPageByComChecker extends BasePage {

    @FindBy(css = "div label input.form-control-sm")
    WebElement fillIftBatchIdEl;

    @FindBy(css = "tr[class='odd'] button[type='button']")
    WebElement clickAuthorizeBtnEl;

    @FindBy(id = "idSubmitButton")
    WebElement clickSubmitButtonEl;

    @FindBy(id = "idRejectButton")
    WebElement clickRejectBtnEl;

    @FindBy(css = "input#idRejectionReason")
    WebElement fillRejectReasonEl;

    @FindBy(id = "messageModalCancleTransactionYesAll")
    WebElement clickYesButtonEl;

    public RTGS_BulkTransactionPageByComChecker(WebDriver driver) {
        super(driver);
    }


    public RTGS_BulkTransactionPageByComChecker searchIFTBatchId(String rtgsRefId) throws InterruptedException {
        getWebElement(By.cssSelector("div label input.form-control-sm")).isDisplayed();
        //iftBatchId = fillIftBatchIdEl.getText();
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + rtgsRefId);
        getWebElement(By.cssSelector("div label input.form-control-sm")).sendKeys(rtgsRefId);
//        fillIftBatchIdEl.sendKeys();
        Thread.sleep(2000);
        return this;
    }


    public RTGS_BulkTransactionPageByComChecker clickAuthorizeBtn() throws InterruptedException {

        getWebElement(By.cssSelector("tr[class='odd'] button[type='button']")).click();
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        Thread.sleep(5000);

        return this;

    }

    public RTGS_BulkTransactionPageByComChecker clickSubmitBtn() throws InterruptedException {
        Thread.sleep(5000);
        getWebElement(By.id("idSubmitButton")).click();
        Thread.sleep(5000);
        return this;

    }

    public RTGS_BulkTransactionPageByComChecker clickRejectBtn() {
        clickRejectBtnEl.isDisplayed();
        clickRejectBtnEl.click();
        return this;

    }

    public RTGS_BulkTransactionPageByComChecker fillRejectReason(String rejectReason) {
        fillRejectReasonEl.isDisplayed();
        clickRejectBtnEl.sendKeys(rejectReason);
        return this;

    }

    public boolean hasSingleTranAuthorizedSuccess() {
        return getWebElement(By.cssSelector("div[aria-modal='true'] div.modal-body p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.TranAuthTranComplete);
        // return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranAuthTranComplete);
        // return getWebElement(By.cssSelector("div.modal-body>p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.TranAuthTranComplete);

    }
}
