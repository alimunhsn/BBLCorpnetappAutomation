package com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.EFT_Pages;
import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Single_EFT_TransactionByComMakerPage extends BasePage {
    public String SingleEftBatch;

    public Single_EFT_TransactionByComMakerPage(WebDriver driver) {
        super(driver);
    }


    public Single_EFT_TransactionByComMakerPage selectComAcc(int index) {
        //getWebElement(By.id("companyAccount")).sendKeys("CompanyAccount");
         new Select(getWebElement(By.id("companyAccount"))).selectByIndex(index);
        return this;
    }

    public Single_EFT_TransactionByComMakerPage selectBeneficiary(int index) {

        new Select(getWebElement(By.id("beneficiary"))).selectByIndex(index);
        return this;
    }

    public Single_EFT_TransactionByComMakerPage fillTrxAmount() {
        getWebElement(By.id("trxAmount")).sendKeys("50000.35");
        return this;
    }

    public Single_EFT_TransactionByComMakerPage fillTrxRemarks() throws InterruptedException {
        getWebElement(By.id("trxRemarks")).sendKeys("IFT_Single_Transaction");
        Thread.sleep(2000);
        return this;
    }

    public Single_EFT_TransactionByComMakerPage clickNextBtn() {
        getWebElement(By.cssSelector("button[class='btn btn-primary'][type='submit']")).click();
        return this;
    }

    public Single_EFT_TransactionByComMakerPage clickConfirmBtn() throws InterruptedException {
        //SingleIftBatch=getIftSingleRefEl.getText();
        SingleEftBatch = getWebElement(By.id("transactionReference")).getAttribute("value");
        Thread.sleep(3000);
        getWebElement(By.cssSelector("button[class='btn btn-primary'][type='submit']")).click();
        return this;
    }

    public boolean hasSingleTranInitiatedSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
    }



}
