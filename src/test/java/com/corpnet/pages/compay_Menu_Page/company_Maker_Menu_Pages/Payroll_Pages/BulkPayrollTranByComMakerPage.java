package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.Payroll_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BulkPayrollTranByComMakerPage extends BasePage {

    public String payrollBatch;
    public String PayrollFillPath;

    public BulkPayrollTranByComMakerPage(WebDriver driver) {
        super(driver);
    }


    public BulkPayrollTranByComMakerPage paymentPurpose(int index) {
        new Select(getWebElement(By.cssSelector("select[name='paymentPurpose']"))).selectByIndex(index);
        return this;
    }

    public BulkPayrollTranByComMakerPage selectMonth(int index) {
        new Select(getWebElement(By.cssSelector("select[name='selectedMonth']"))).selectByIndex(index);
        return this;
    }

    public BulkPayrollTranByComMakerPage selectYear(int index) {
        new Select(getWebElement(By.cssSelector("select[name='selectedYear']"))).selectByIndex(index);
        return this;
    }

    public BulkPayrollTranByComMakerPage fileUpload(String PayrollFillPath) {
        // PayrollFillPath = System.getProperty("user.dir") + getPayrollBulk();
        getWebElement(By.cssSelector("#file")).sendKeys(PayrollFillPath);
        return this;

    }

    public BulkPayrollTranByComMakerPage clickUploadBtn() {
        getWebElement(By.id("uploadBtn")).click();
        return this;
    }


    public BulkPayrollTranByComMakerPage clickConfirmBtn() throws InterruptedException {
        Thread.sleep(5000);
        payrollBatch = getWebElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)")).getText();
        getWebElement(By.xpath("//*[@id=\"movenextpage\"]")).click();
        Thread.sleep(3000);
        return this;

    }

    public BulkPayrollTranByComMakerPage sucessOkButton() throws InterruptedException {
        getWebElement(By.id("globalAlertOk")).click();
        Thread.sleep(5000);
        return this;

    }

    public boolean hasSingleTranInitiatedSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
    }

}

