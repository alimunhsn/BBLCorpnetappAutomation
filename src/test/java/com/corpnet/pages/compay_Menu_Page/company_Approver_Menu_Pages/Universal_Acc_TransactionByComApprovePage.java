package com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages;

import com.corpnet.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Universal_Acc_TransactionByComApprovePage extends BasePage {


    public String SpAuthBatchRef;

    public Universal_Acc_TransactionByComApprovePage(WebDriver driver) {
        super(driver);
    }


    public Universal_Acc_TransactionByComApprovePage searchIFTBatchId(String spAuthBatchRef) throws InterruptedException {
        Thread.sleep(1000);
        ;
        getWebElement(By.cssSelector("div label input[aria-controls='universalApprover']")).sendKeys(spAuthBatchRef);
        Thread.sleep(3000);
        return this;
    }

    public Universal_Acc_TransactionByComApprovePage clickApproveBtn() throws InterruptedException {
        getWebElement(By.cssSelector("div table tbody tr td button[class$='btn btn-success'][\\type='button']")).click();
        Thread.sleep(5000);
        return this;
    }

    public Universal_Acc_TransactionByComApprovePage inputTokenNumber() throws InterruptedException {

        getWebElement(By.xpath("//input[@class='form-control pincode-input-text integer first']")).sendKeys("9");
        getWebElement(By.xpath("//tbody//tr//input[2]")).sendKeys("3");
        getWebElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("3");
        getWebElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9");
        getWebElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("4");
        getWebElement(By.cssSelector(".form-control.pincode-input-text.integer.last")).sendKeys("6");
        return this;
    }

    public Universal_Acc_TransactionByComApprovePage clickApproveTokenBtn() throws InterruptedException {
        getWebElement(By.id("approveLink")).click();
        Thread.sleep(2000);
        return this;
    }

    public Universal_Acc_TransactionByComApprovePage clickYesBtn() throws InterruptedException {
        getWebElement(By.id("okModalYes")).click();
        Thread.sleep(2000);
        return this;
    }


}