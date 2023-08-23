package com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFT_TransactionByComApprovePage extends BasePage {
    public String iftChBatch;


    public IFT_TransactionByComApprovePage(WebDriver driver) {
        super(driver);
    }


    public IFT_TransactionByComApprovePage searchIFTBatchId(String iftRefID) throws InterruptedException {
        //   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        getWebElement(By.cssSelector("div label input.form-control-sm")).sendKeys(iftRefID);
        Thread.sleep(3000);
        return this;
    }

    public IFT_TransactionByComApprovePage clickApproveBtn() throws InterruptedException {
        getWebElement(By.cssSelector("div table tbody tr td button[class$='btn btn-success'][\\type='button']")).click();
        Thread.sleep(15000);
        return this;
    }

    public IFT_TransactionByComApprovePage inputTokenNumber() {
        getWebElement(By.xpath("//input[@class='form-control pincode-input-text integer first']")).sendKeys("9");
        getWebElement(By.xpath("//tbody//tr//input[2]")).sendKeys("3");
        getWebElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("3");
        getWebElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9");
        getWebElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("4");
        getWebElement(By.cssSelector(".form-control.pincode-input-text.integer.last")).sendKeys("6");
        return this;
    }

    public IFT_TransactionByComApprovePage clickApproveTokenBtn() throws InterruptedException {
        getWebElement(By.id("approveLink")).click();
        Thread.sleep(2000);
        return this;
    }

    public IFT_TransactionByComApprovePage clickYesBtn() throws InterruptedException {
        getWebElement(By.id("okModalYes")).click();
        Thread.sleep(2000);
        return this;
    }

    public boolean hasSingleTranApprovedSuccess() {
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.IFTApproveTranComplete);
    }



}
