package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.RTGS_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;

public class RTGS_BulkTransactionByComMakerPage extends BasePage {
    public String rtgsBatchRef;
    public String RTGSBulkFile,RTGSFutureBulkFile;

    @FindBy(css = "#moveCancelPage")
    WebElement clickCancelEl;

    @FindBy(id = "idRejectionReasonCancleTransactionAll")
    WebElement fillRejectReasonEl;

    @FindBy(id = "messageModalCancleTransactionYesAll")
    WebElement clickYesButtonEl;

//     @FindBy(css = "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)")
//     WebElement getTextEl;

    @FindBy(css = "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)")
    WebElement gettextFromBatch;

    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr/td[2]")
    WebElement selectBatchEl;

    public RTGS_BulkTransactionByComMakerPage(WebDriver driver) {
        super(driver);
    }


    public RTGS_BulkTransactionByComMakerPage selectAccountNo(int index) {
        new Select(getWebElement(By.id("accountId"))).selectByIndex(index);
        return this;
    }

    public RTGS_BulkTransactionByComMakerPage uploadIFTFile() {
        getWebElement(By.cssSelector("input#file")).sendKeys(RTGSBulkFile);
        return this;

    }

    public RTGS_BulkTransactionByComMakerPage fillRemarks(String remarks) {

        getWebElement(By.id("debitRemarks")).sendKeys(remarks);
        return this;

    }

    public RTGS_BulkTransactionByComMakerPage clickUploadBtn() throws InterruptedException {

        getWebElement(By.id("uploadBtn")).click();
        Thread.sleep(10000);
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        return this;
    }


    public RTGS_BulkTransactionByComMakerPage clickConfirmBtn() throws FileNotFoundException, InterruptedException {


        rtgsBatchRef = getWebElement(By.xpath("/html/body/div/div/div[1]/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr/td[2]")).getText();
        Thread.sleep(3000);
        getWebElement(By.cssSelector("button#movenextpage")).click();
        return this;
    }

    public RTGS_BulkTransactionByComMakerPage clickRadioMulti() {
        getWebElement(By.cssSelector("div label>input[value='2'][name='debitMode']")).click();

        return this;
    }

    public RTGS_BulkTransactionByComMakerPage clickCancel() {
        // GeneralUtil.waitForDomStable();
        clickCancelEl.isDisplayed();
        clickCancelEl.click();
        return this;
    }

    public RTGS_BulkTransactionByComMakerPage fillRejectReason(String RejectReason) {

        // GeneralUtil.waitForDomStable();
        fillRejectReasonEl.isDisplayed();
        fillRejectReasonEl.sendKeys(RejectReason);
        return this;
    }

    public RTGS_BulkTransactionByComMakerPage ClickRejectYesButton() {

        // GeneralUtil.waitForDomStable();
        clickYesButtonEl.isDisplayed();
        clickYesButtonEl.click();
        return this;
    }
    public boolean hasRTGS_Bulk_TranInitiatedSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
    }


}
