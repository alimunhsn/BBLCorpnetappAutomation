package com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class RTGS_BulkTransactionPageByComApprover extends BasePage {

    public String debitAccount;
    @FindBy(css = "div label input.form-control-sm")
    WebElement fillIftBatchIdEl;


    @FindBy(css = "div table tbody tr td button[class$='btn btn-success'][\\type='button']")
    WebElement clickApproveBtnEl;

    @FindBy(id = "approveLink")
    WebElement submitButton;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div/div/div[1]/div/form[1]/div[2]/table/tbody/tr[2]/td[2]/div/input[1]")
    WebElement firstTokeNumberEl;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div/div/div[1]/div/form[1]/div[2]/table/tbody/tr[2]/td[2]/div/input[2]")
    WebElement seconedTokeNumberEl;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div/div/div[1]/div/form[1]/div[2]/table/tbody/tr[2]/td[2]/div/input[3]")
    WebElement thirdTokenNumberEl;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div/div/div[1]/div/form[1]/div[2]/table/tbody/tr[2]/td[2]/div/input[4]")
    WebElement fourthTokenNumberEl;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div/div/div[1]/div/form[1]/div[2]/table/tbody/tr[2]/td[2]/div/input[5]")
    WebElement fifthTokenNumberEl;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div/div/div[1]/div/form[1]/div[2]/table/tbody/tr[2]/td[2]/div/input[6]")
    WebElement sixthTokenNumberEl;

    @FindBy(id = "approveLink")
    WebElement clickapproveBtnEl;

    @FindBy(id = "okModalYes")
    WebElement finalOk;

    @FindBy(id = "globalAlertOk")
    WebElement finalOkButton;

    public RTGS_BulkTransactionPageByComApprover(WebDriver driver) {
        super(driver);
    }

    public RTGS_BulkTransactionPageByComApprover searchRTGSBatchId(String RTGSRefID) throws InterruptedException {
        //   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        getWebElement(By.cssSelector("div label input.form-control-sm")).sendKeys(RTGSRefID);
        Thread.sleep(3000);
        return this;
    }

    public RTGS_BulkTransactionPageByComApprover clickApproveBtn() throws InterruptedException {
        getWebElement(By.cssSelector("div table tbody tr td button[class$='btn btn-success'][\\type='button']")).click();
        debitAccount = getWebElement(By.cssSelector("tr[role='row'] td:nth-child(5)")).getText();
        System.out.println(debitAccount);
        Thread.sleep(5000);
        return this;
    }

    public RTGS_BulkTransactionPageByComApprover getDebitAccount() throws InterruptedException {
        debitAccount = getWebElement(By.cssSelector("tr[role='row'] td:nth-child(5)")).getText();
        return this;
    }

    public RTGS_BulkTransactionPageByComApprover inputTokenNumber() {
        getWebElement(By.xpath("//input[@class='form-control pincode-input-text integer first']")).sendKeys("9");
        getWebElement(By.xpath("//tbody//tr//input[2]")).sendKeys("3");
        getWebElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("3");
        getWebElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9");
        getWebElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("4");
        getWebElement(By.cssSelector(".form-control.pincode-input-text.integer.last")).sendKeys("6");
        return this;
    }

    public RTGS_BulkTransactionPageByComApprover clickApproveTokenBtn() throws InterruptedException {
        getWebElement(By.id("approveLink")).click();
        Thread.sleep(2000);
        return this;
    }

    public RTGS_BulkTransactionPageByComApprover clickYesBtn() throws InterruptedException {
        getWebElement(By.id("okModalYes")).click();
        Thread.sleep(2000);
        return this;
    }


    public RTGS_BulkTransactionPageByComApprover clickOkButton() throws InterruptedException {

        Thread.sleep(5000);
        getWebElement(By.id("okModalYes")).click();
        return this;

    }


    public boolean hasRTGSSingleTranApprovedSuccess() {
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.ApproveTranComplete);
    }


}
