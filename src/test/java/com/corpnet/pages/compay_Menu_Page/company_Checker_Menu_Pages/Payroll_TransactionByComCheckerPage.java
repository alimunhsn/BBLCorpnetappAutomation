package com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Payroll_TransactionByComCheckerPage extends BasePage {

    @FindBy(id = "idRejectButton")
    WebElement clickRejectBtnEl;

    @FindBy(css = "input#idRejectionReason")
    WebElement fillRejectReasonEl;

    @FindBy(id = "messageModalCancleTransactionYesAll")
    WebElement clickYesButtonEl;

    public Payroll_TransactionByComCheckerPage(WebDriver driver) {
        super(driver);
    }


    public Payroll_TransactionByComCheckerPage searchIFTBatchId(String payrollRef) throws InterruptedException {
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + payrollRef);
        getWebElement(By.cssSelector("div label input[aria-controls='dataTable-payroll']")).sendKeys(payrollRef);
        Thread.sleep(2000);
        return this;
    }

    public Payroll_TransactionByComCheckerPage clickAuthorizeBtn() throws InterruptedException {
        getWebElement(By.cssSelector("#dataTable-payroll > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(8) > button:nth-child(1)")).click();
        Thread.sleep(15000);
        return this;
    }

    public Payroll_TransactionByComCheckerPage clickSigRadioBtn() {
        getWebElement(By.cssSelector(".even > td:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).click();
        return this;
    }

    public Payroll_TransactionByComCheckerPage clickSubmitBtn() {
        getWebElement(By.id("idSubmitButton")).click();
        return this;

    }

    public Payroll_TransactionByComCheckerPage clickRejectBtn() {
        clickRejectBtnEl.isDisplayed();
        clickRejectBtnEl.click();
        return this;

    }

    public Payroll_TransactionByComCheckerPage fillRejectReason(String rejectReason) {
        fillRejectReasonEl.isDisplayed();
        clickRejectBtnEl.sendKeys(rejectReason);
        return this;

    }

    public boolean hasSingleTranAuthorizedSuccess() {
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranAuthTranComplete);
    }



}




