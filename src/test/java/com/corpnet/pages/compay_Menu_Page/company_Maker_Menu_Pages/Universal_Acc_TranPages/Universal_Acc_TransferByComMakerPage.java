package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.Universal_Acc_TranPages;

import com.corpnet.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Universal_Acc_TransferByComMakerPage extends BasePage {

    public String UnBatchRef;
    public String SpOwnFileUpload, SpThirdFileUpload;

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


    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr/td[3]")
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

    public Universal_Acc_TransferByComMakerPage(WebDriver driver) {
        super(driver);
    }


    public Universal_Acc_TransferByComMakerPage selectAccountNo(int index) {
        new Select(getWebElement(By.id("accountId"))).selectByIndex(index);
        return this;
    }

    public Universal_Acc_TransferByComMakerPage uploadIFTFile() {
        getWebElement(By.cssSelector("input#file")).sendKeys(SpOwnFileUpload);
        return this;

    }

    public Universal_Acc_TransferByComMakerPage fillRemarks(String remarks) {
        getWebElement(By.name("debitRemarks")).sendKeys(remarks);
        return this;

    }

    public Universal_Acc_TransferByComMakerPage clickUploadBtn() throws InterruptedException {
        getWebElement(By.id("uploadBtn")).click();
        Thread.sleep(10000);
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        return this;

    }

    public Universal_Acc_TransferByComMakerPage clickConfirmBtn() throws InterruptedException {
        Thread.sleep(5000);
        UnBatchRef = getWebElement(By.xpath("/html/body/div/div/div[1]/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr/td[3]")).getText();
        getWebElement(By.xpath("//*[@id=\"movenextpage\"]")).click();

        Thread.sleep(3000);

        return this;

    }

    public Universal_Acc_TransferByComMakerPage getEftBatchId() {

        selectBatchEl.isDisplayed();
        selectBatchEl.getText();

        return this;

    }


    public Universal_Acc_TransferByComMakerPage clickRadioMulti() {
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        debitModeMultiEl.isDisplayed();
        debitModeMultiEl.click();

        return this;

    }

    public Universal_Acc_TransferByComMakerPage clickCancel() {
        clickCancelEl.isDisplayed();
        clickCancelEl.click();
        return this;


    }

    public Universal_Acc_TransferByComMakerPage fillRejectReason(String RejectReason) {

        // GeneralUtil.waitForDomStable();
        fillRejectReasonEl.isDisplayed();
        fillRejectReasonEl.sendKeys(RejectReason);
        return this;


    }

    public Universal_Acc_TransferByComMakerPage ClickRejectYesButton() {

        // GeneralUtil.waitForDomStable();
        clickYesButtonEl.isDisplayed();
        clickYesButtonEl.click();
        return this;


    }


}
