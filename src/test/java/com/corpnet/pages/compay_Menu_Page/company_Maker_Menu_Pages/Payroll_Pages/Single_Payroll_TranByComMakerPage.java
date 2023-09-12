package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.Payroll_Pages;

import com.corpnet.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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


}
