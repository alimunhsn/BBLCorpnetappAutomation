package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.DD_Pages;

import com.corpnet.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DD_Transaction_ByComMakerPage extends BasePage {
    public String DDBatchRefNo;
    public String DDOwnFileUpload;

    @FindBy(id = "accountId")
    WebElement accountIdEl;

    @FindBy(css = "input#file")
    WebElement browseEl;

    @FindBy(name = "debitRemarks")
    WebElement fillRemarksEl;
    @FindBy(id = "uploadBtn")
    WebElement clickUploadEl;
    @FindBy(xpath = "//*[@id=\"movenextpage\"]")
    WebElement clickConfirmBtnEl;


    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr/td[2]")
    WebElement selectBatchEl;
    @FindBy(css = "div label>input[value='2'][name='debitMode']")
    WebElement debitModeMultiEl;

    @FindBy(css = "h1.card-title:nth-child(3)")
    WebElement getFileDetailsEl;
    @FindBy(css = "#moveCancelPage")
    WebElement clickCancelEl;

    @FindBy(id = "idRejectionReasonCancleTransactionAll")
    WebElement fillRejectReasonEl;

    @FindBy(id = "messageModalCancleTransactionYesAll")
    WebElement clickYesButtonEl;

    public DD_Transaction_ByComMakerPage(WebDriver driver) {
        super(driver);
    }


    public DD_Transaction_ByComMakerPage selectAccountNo(int index) {

        accountIdEl.isDisplayed();
        new Select(accountIdEl).selectByIndex(index);
        return this;
    }

    public DD_Transaction_ByComMakerPage uploadIFTFile() {
        //DDOwnFileUpload = System.getProperty("user.dir") + getDDWonBulk();
        browseEl.isDisplayed();
        browseEl.sendKeys(DDOwnFileUpload);
        return this;

    }

    public DD_Transaction_ByComMakerPage uploadDDOthersIFTFile() {
        //  DDOwnFileUpload = System.getProperty("user.dir") + getDDWonBulk();
        browseEl.isDisplayed();
        browseEl.sendKeys(DDOwnFileUpload);
        return this;

    }


    public DD_Transaction_ByComMakerPage fillRemarks(String remarks) {

        fillRemarksEl.isDisplayed();
        fillRemarksEl.sendKeys(remarks);
        return this;

    }

    public DD_Transaction_ByComMakerPage clickUploadBtn() throws InterruptedException {

        clickUploadEl.isDisplayed();
        clickUploadEl.click();
        Thread.sleep(5000);
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        return this;

    }

    public DD_Transaction_ByComMakerPage clickConfirmBtn() throws InterruptedException {
        Thread.sleep(5000);

        selectBatchEl.isDisplayed();
        DDBatchRefNo = selectBatchEl.getText();
        clickConfirmBtnEl.isDisplayed();
        clickConfirmBtnEl.click();

        Thread.sleep(3000);

        return this;

    }

    public DD_Transaction_ByComMakerPage getIftBatchId() {

        selectBatchEl.isDisplayed();
        selectBatchEl.getText();

        return this;

    }


    public DD_Transaction_ByComMakerPage clickRadioMulti() {
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        debitModeMultiEl.isDisplayed();
        debitModeMultiEl.click();

        return this;

    }

    public DD_Transaction_ByComMakerPage clickCancel() {
        clickCancelEl.isDisplayed();
        clickCancelEl.click();
        return this;


    }

    public DD_Transaction_ByComMakerPage fillRejectReason(String RejectReason) {

        // GeneralUtil.waitForDomStable();
        fillRejectReasonEl.isDisplayed();
        fillRejectReasonEl.sendKeys(RejectReason);
        return this;


    }

    public DD_Transaction_ByComMakerPage ClickRejectYesButton() {

        // GeneralUtil.waitForDomStable();
        clickYesButtonEl.isDisplayed();
        clickYesButtonEl.click();
        return this;


    }


}
