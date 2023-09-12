package com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payroll_TransactionByComApprovePage extends BasePage {


    public String payrollSingleBatchRef;

    public Payroll_TransactionByComApprovePage(WebDriver driver) {
        super(driver);
    }


    public Payroll_TransactionByComApprovePage searchIFTBatchId(String payrollRef) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + payrollRef);
        getWebElement(By.cssSelector("div label input[aria-controls='dataTable-payroll']")).sendKeys(payrollRef);
        Thread.sleep(2000);
        return this;
    }

    public Payroll_TransactionByComApprovePage clickApproveBtn() throws InterruptedException {
        getWebElement(By.cssSelector("td.dtfc-fixed-right:nth-child(9) > button:nth-child(1) > svg:nth-child(1)")).click();
        Thread.sleep(2000);
        return this;
    }

    public Payroll_TransactionByComApprovePage inputTokenNumber() {
        getWebElement(By.xpath("//input[@class='form-control pincode-input-text integer first']")).sendKeys("9");
        getWebElement(By.xpath("//tbody//tr//input[2]")).sendKeys("3");
        getWebElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("3");
        getWebElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9");
        getWebElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("4");
        getWebElement(By.cssSelector(".form-control.pincode-input-text.integer.last")).sendKeys("6");
        return this;
    }

    public Payroll_TransactionByComApprovePage clickApproveTokenBtn() throws InterruptedException {
        getWebElement(By.id("approveLink")).click();
        Thread.sleep(2000);
        return this;
    }

    public Payroll_TransactionByComApprovePage clickYesBtn() throws InterruptedException {
        getWebElement(By.id("okModalYes")).click();
        Thread.sleep(2000);
        return this;
    }

    public boolean hasSingleTranApprovedSuccess() {
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.ApproveTranComplete);
    }

}