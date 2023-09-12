package com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EFT_TransactionByComApprovePage extends BasePage {
    public String EftChBatch;
    public String debitAccount;


    public EFT_TransactionByComApprovePage(WebDriver driver) {
        super(driver);
    }


    public EFT_TransactionByComApprovePage searchIFTBatchId(String iftSingleRefID) throws InterruptedException {
        Thread.sleep(5000);
        getWebElement(By.cssSelector("div label input.form-control-sm")).sendKeys(iftSingleRefID);
        Thread.sleep(3000);
        return this;
    }

    public EFT_TransactionByComApprovePage clickApproveBtn() throws InterruptedException {
        getWebElement(By.cssSelector("div table tbody tr td button[class$='btn btn-success'][\\type='button']")).click();
        debitAccount = getWebElement(By.cssSelector("tr[role='row'] td:nth-child(5)")).getText();
        System.out.println(debitAccount);
        Thread.sleep(5000);
        return this;
    }

    public EFT_TransactionByComApprovePage clickOkkBtn() throws InterruptedException {

        if (getWebElement(By.id("idMessageModalYes")).isDisplayed()) {
            String alertMessage = getWebElement(By.cssSelector("p[id='idRTGSWarn'] label")).getText();
            System.out.println(alertMessage);
            Thread.sleep(5000);
            //clickOkBtnEl.isDisplayed();
            getWebElement(By.id("idMessageModalYes")).click();
        }
        return this;
    }

    public EFT_TransactionByComApprovePage inputTokenNumber() {

        getWebElement(By.xpath("//input[@class='form-control pincode-input-text integer first']")).sendKeys("9");
        getWebElement(By.xpath("//tbody//tr//input[2]")).sendKeys("3");
        getWebElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("3");
        getWebElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9");
        getWebElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("4");
        getWebElement(By.cssSelector(".form-control.pincode-input-text.integer.last")).sendKeys("6");
        return this;
    }

    public EFT_TransactionByComApprovePage clickApproveTokenBtn() throws InterruptedException {
        getWebElement(By.id("approveLink")).click();
        Thread.sleep(2000);
        return this;
    }

    public EFT_TransactionByComApprovePage clickYesBtn() throws InterruptedException {
        getWebElement(By.id("okModalYes")).click();
        Thread.sleep(2000);
        return this;
    }

    public boolean hasTransactionApprovedSuccess() {
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.ApproveTranComplete);
    }



}
