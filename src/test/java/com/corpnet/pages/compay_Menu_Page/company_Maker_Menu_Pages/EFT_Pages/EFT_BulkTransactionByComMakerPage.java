package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.EFT_Pages;
import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EFT_BulkTransactionByComMakerPage extends BasePage {

    public String EftBatchRef;
    public String EFTSingleFile,EFTMultiFIle;



    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr/td[2]")
    WebElement selectBatchEl;
    @FindBy(css = "#moveCancelPage")
    WebElement clickCancelEl;

    @FindBy(id = "idRejectionReasonCancleTransactionAll")
    WebElement fillRejectReasonEl;

    @FindBy(id = "messageModalCancleTransactionYesAll")
    WebElement clickYesButtonEl;

    public EFT_BulkTransactionByComMakerPage(WebDriver driver) {
        super(driver);
    }


    public EFT_BulkTransactionByComMakerPage selectAccountNo(int index) {
        new Select(getWebElement(By.id("accountId"))).selectByIndex(index);
        return this;
    }

    public EFT_BulkTransactionByComMakerPage uploadIFTFile( String EftSingleBulk) {
        getWebElement(By.cssSelector("input#file")).sendKeys(EftSingleBulk);
        return this;

    }

    public EFT_BulkTransactionByComMakerPage uploadIFTMultiFile(String EFTMultiFIle) {
      //  EFTMultiFIle=System.getProperty("user.dir")+getEFTMultipleBulk();
        getWebElement(By.cssSelector("input#file")).sendKeys(EFTMultiFIle);
        return this;

    }

    public EFT_BulkTransactionByComMakerPage fillRemarks(String remarks) {
        getWebElement(By.name("debitRemarks")).sendKeys(remarks);
        return this;

    }

    public EFT_BulkTransactionByComMakerPage clickUploadBtn() throws InterruptedException {

        getWebElement(By.id("uploadBtn")).click();
        Thread.sleep(10000);
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        return this;

    }

    public EFT_BulkTransactionByComMakerPage clickConfirmBtn() throws InterruptedException {
        Thread.sleep(5000);

        EftBatchRef = getWebElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")).getText();
        getWebElement(By.cssSelector("button#movenextpage")).click();
        Thread.sleep(3000);

        return this;

    }

    public EFT_BulkTransactionByComMakerPage getEftBatchId() {

        selectBatchEl.isDisplayed();
        selectBatchEl.getText();

        return this;

    }


    public EFT_BulkTransactionByComMakerPage clickRadioMulti() {
        getWebElement(By.cssSelector("div label>input[value='2'][name='debitMode']")).click();
        return this;

    }

    public EFT_BulkTransactionByComMakerPage clickCancel() {
        // GeneralUtil.waitForDomStable();
        clickCancelEl.isDisplayed();
        clickCancelEl.click();
        return this;

    }

    public EFT_BulkTransactionByComMakerPage fillRejectReason(String RejectReason) {

        // GeneralUtil.waitForDomStable();
        fillRejectReasonEl.isDisplayed();
        fillRejectReasonEl.sendKeys(RejectReason);
        return this;


    }

    public EFT_BulkTransactionByComMakerPage ClickRejectYesButton() {

        // GeneralUtil.waitForDomStable();
        clickYesButtonEl.isDisplayed();
        clickYesButtonEl.click();
        return this;


    }

    public boolean hasBulkTranInitiatedSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
    }



}
