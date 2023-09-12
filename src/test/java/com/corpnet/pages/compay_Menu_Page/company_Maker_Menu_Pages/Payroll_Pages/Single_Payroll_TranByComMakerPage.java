package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.Payroll_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Single_Payroll_TranByComMakerPage extends BasePage {

    public String PayrollTrxRefNo;

    public Single_Payroll_TranByComMakerPage(WebDriver driver) {
        super(driver);
    }


    public Single_Payroll_TranByComMakerPage selectComAcc(int index) {
        new Select(getWebElement(By.id("companyAccount"))).selectByIndex(index);
        return this;
    }

    public Single_Payroll_TranByComMakerPage selectBeneficiary(int index) {
        new Select(getWebElement(By.id("beneficiary"))).selectByIndex(index);
        return this;
    }

    public Single_Payroll_TranByComMakerPage fillTrxAmount() {
        getWebElement(By.id("trxAmount")).sendKeys("50000.35");
        return this;
    }

    public Single_Payroll_TranByComMakerPage fillTrxRemarks() throws InterruptedException {
        getWebElement(By.id("trxRemarks")).sendKeys("Payroll_Single_Transaction");
        Thread.sleep(1000);
        return this;
    }

    public Single_Payroll_TranByComMakerPage clickNextBtn() {
        getWebElement(By.cssSelector("button[class='btn btn-primary'][type='submit']")).click();
        return this;
    }

    public Single_Payroll_TranByComMakerPage clickConfirmBtn() throws InterruptedException {
        //SingleIftBatch=getIftSingleRefEl.getText();
        PayrollTrxRefNo = getWebElement(By.cssSelector("div form input[name='trxReference']")).getAttribute("value");
        Thread.sleep(3000);
        getWebElement(By.cssSelector("button[class='btn btn-primary'][type='submit']")).click();

        return this;
    }

    public boolean hasSingleTranInitiatedSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
    }



}
