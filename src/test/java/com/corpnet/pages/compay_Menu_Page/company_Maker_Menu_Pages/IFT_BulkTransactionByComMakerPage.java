package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class IFT_BulkTransactionByComMakerPage extends BasePage {

    public String iftBatch, iftPayrollBatch;
    public String IftPayrollFilePath;
    public String IftMultiFilepath;

    @FindBy(id = "accountId")
    WebElement accountIdEl;

    @FindBy(css = "input#file")
    WebElement browseEl;

    @FindBy(name = "debitRemarks")
    WebElement fillRemarksEl;

    @FindBy(id = "#idMessageModalYes")
    WebElement clickOkBtnEl;
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

    //  use for payroll selector
    @FindBy(css = "input[value='Y']")
    WebElement selectPayrollYesEl;

    @FindBy(id = "paymentPurpose")
    WebElement selectPurposeEl;
    @FindBy(id = "selectedMonth")
    WebElement selectMonthEl;
    @FindBy(id = "selectedYear")
    WebElement selectYearEl;

    public IFT_BulkTransactionByComMakerPage(WebDriver driver) {
        super(driver);
    }


    public IFT_BulkTransactionByComMakerPage selectAccountNo(int index) {

        new Select(getWebElement(By.id("accountId"))).selectByIndex(index);
        return this;

    }

    public IFT_BulkTransactionByComMakerPage uploadIFTFile(String iftSingleBulkFile) throws InterruptedException {
        getWebElement(By.cssSelector("input#file")).sendKeys(iftSingleBulkFile);
        Thread.sleep(5000);
        return this;

    }

    public IFT_BulkTransactionByComMakerPage uploadIFTMultiFile(String iftMultiFilepath) {
        getWebElement(By.cssSelector("input#file")).sendKeys(IftMultiFilepath);
        System.out.println(IftMultiFilepath);
        return this;
    }

    public IFT_BulkTransactionByComMakerPage fillRemarks(String remarks) {
        getWebElement(By.name("debitRemarks")).sendKeys(remarks);
        return this;

    }

    public IFT_BulkTransactionByComMakerPage clickUploadBtn() throws InterruptedException {
        getWebElement(By.id("uploadBtn")).click();
        Thread.sleep(8000);
        iftBatch = getWebElement(By.xpath("/html/body/div/div/div[1]/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr/td[2]")).getText();
        System.out.println(iftBatch);
        Thread.sleep(2000);
        return this;
    }

    public IFT_BulkTransactionByComMakerPage clickConfirmBtn() throws InterruptedException {

        getWebElement(By.cssSelector("button#movenextpage")).click();

        Thread.sleep(3000);
        return this;
    }

    public IFT_BulkTransactionByComMakerPage getIftBatchId() {
        iftBatch = getWebElement(By.xpath("/html/body/div/div/div[1]/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr/td[2]")).getText();
        System.out.println(iftBatch);

        return this;

    }


    public IFT_BulkTransactionByComMakerPage clickRadioMulti() {
        getWebElement(By.cssSelector("div label>input[value='2'][name='debitMode']")).click();
        return this;

    }

    public IFT_BulkTransactionByComMakerPage clickCancel() {
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        // GeneralUtil.waitForDomStable();
        clickCancelEl.isDisplayed();
        clickCancelEl.click();
        return this;


    }

    public IFT_BulkTransactionByComMakerPage fillRejectReason(String RejectReason) {

        // GeneralUtil.waitForDomStable();
        fillRejectReasonEl.isDisplayed();
        fillRejectReasonEl.sendKeys(RejectReason);
        return this;


    }

    public IFT_BulkTransactionByComMakerPage ClickRejectYesButton() {

        // GeneralUtil.waitForDomStable();
        clickYesButtonEl.isDisplayed();
        clickYesButtonEl.click();
        return this;

    }

    public IFT_BulkTransactionByComMakerPage SelectPayrollRedioButton() {

        // GeneralUtil.waitForDomStable();
        selectPayrollYesEl.isDisplayed();
        selectPayrollYesEl.click();
        return this;

    }

    public IFT_BulkTransactionByComMakerPage SelectPayrollPurpose() throws InterruptedException {

        // GeneralUtil.waitForDomStable();
        selectPurposeEl.isDisplayed();
        Thread.sleep(200);
        new Select(selectPurposeEl).selectByVisibleText("Salary");
        //   electByValue("16");
        selectMonthEl.isDisplayed();
        Thread.sleep(2000);
        new Select(selectMonthEl).selectByVisibleText("June");
        selectYearEl.isDisplayed();
        new Select(selectYearEl).selectByVisibleText("2023");
        return this;

    }

    public IFT_BulkTransactionByComMakerPage uploadIFTPayrollFile() {
        //IftPayrollFilePath= System.getProperty("user.dir")+getPayrollBulk();
        System.out.println(IftPayrollFilePath);
        browseEl.isDisplayed();
        browseEl.sendKeys(IftPayrollFilePath);
        return this;
    }

    public IFT_BulkTransactionByComMakerPage fillPayrollRemarks(String remarks) {

        fillRemarksEl.isDisplayed();
        fillRemarksEl.sendKeys(remarks);
        return this;

    }

    public IFT_BulkTransactionByComMakerPage clickPayrollConfirmBtn() throws InterruptedException {
        Thread.sleep(5000);

        selectBatchEl.isDisplayed();
        iftPayrollBatch = selectBatchEl.getText();
        clickConfirmBtnEl.isDisplayed();
        clickConfirmBtnEl.click();

        Thread.sleep(3000);

        return this;

    }

    public boolean hasSingleBulkTranInitiatedSuccess() {

        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.IFTSingleTranComplete);
        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        //return getWebElement(By.linkText("Your transaction request has been initiated successfully.")).getText().trim().contains(CorpnetStringMeg.IFTSingleTranComplete);
    }

    public boolean hasMultiBulkTranInitiatedSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        return getWebElement(By.linkText("Your transaction request has been initiated successfully.")).getText().trim().contains(CorpnetStringMeg.IFTSingleTranComplete);
    }


}
