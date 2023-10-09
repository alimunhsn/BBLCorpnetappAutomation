package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class IFT_BulkTransactionByComMakerPage extends BasePage {

    public String iftBatch, iftPayrollBatch;

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

    public IFT_BulkTransactionByComMakerPage uploadIFTMultiFile(String IftMultiFilepath) {
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


    public IFT_BulkTransactionByComMakerPage clickRadioMulti() {
        getWebElement(By.cssSelector("div label>input[value='2'][name='debitMode']")).click();
        return this;

    }

      public IFT_BulkTransactionByComMakerPage SelectPayrollRadioButton() {
        getWebElement(By.cssSelector("input[value='Y']")).click();
        // GeneralUtil.waitForDomStable();
        return this;

    }

    public IFT_BulkTransactionByComMakerPage SelectPayrollPurpose()  {

        // GeneralUtil.waitForDomStable();
        new Select(getWebElement(By.id("paymentPurpose"))).selectByVisibleText("Salary");

        //   electByValue("16");
        new Select(getWebElement(By.id("selectedMonth"))).selectByVisibleText("June");

        new Select(getWebElement(By.id("selectedYear"))).selectByVisibleText("2023");
        return this;

    }


    public IFT_BulkTransactionByComMakerPage clickPayrollConfirmBtn() throws InterruptedException {
        Thread.sleep(2000);
        iftPayrollBatch = getWebElement(By.xpath("/html/body/div/div/div[1]/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr/td[2]"))
                .getText();
        Thread.sleep(3000);

        getWebElement(By.xpath("//*[@id=\"movenextpage\"]")).click();

        Thread.sleep(3000);

        return this;

    }

    public boolean hasSingleBulkTranInitiatedSuccess() {

        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        //return getWebElement(By.linkText("Your transaction request has been initiated successfully.")).getText().trim().contains(CorpnetStringMeg.IFTSingleTranComplete);
    }

    public boolean hasMultiBulkTranInitiatedSuccess() {
      //  return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
        return getWebElement(By.cssSelector("div.modal-body>p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        //return getWebElement(By.linkText("Your transaction request has been initiated successfully.")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
    }


}
