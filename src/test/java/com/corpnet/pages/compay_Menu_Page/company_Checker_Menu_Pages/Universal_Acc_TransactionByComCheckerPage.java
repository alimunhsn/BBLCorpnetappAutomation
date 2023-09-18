package com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages;

import com.corpnet.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Universal_Acc_TransactionByComCheckerPage extends BasePage {
    public String SpAuthBatchId;


    @FindBy(css = "div label input.form-control-sm")
    WebElement fillIftBatchIdEl;

    @FindBy(css = "tr[class='odd'] button[type='button']")
    WebElement clickAuthorizeBtnEl;

    @FindBy(id = "idSubmitButton")
    WebElement clickSubmitButtonEl;

    @FindBy(id = "idRejectButton")
    WebElement clickRejectBtnEl;

    @FindBy(css = "input#idRejectionReason")
    WebElement fillRejectReasonEl;

    @FindBy(id = "messageModalCancleTransactionYesAll")
    WebElement clickYesButtonEl;

    public Universal_Acc_TransactionByComCheckerPage(WebDriver driver) {
        super(driver);
    }


    public Universal_Acc_TransactionByComCheckerPage searchSpAuthBatchId(String iftID) throws InterruptedException {
        fillIftBatchIdEl.isDisplayed();
        //iftBatchId = fillIftBatchIdEl.getText();
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + iftID);
        fillIftBatchIdEl.sendKeys(iftID);
//        fillIftBatchIdEl.sendKeys();
        Thread.sleep(2000);
        return this;
    }


    public Universal_Acc_TransactionByComCheckerPage clickAuthorizeBtn() throws InterruptedException {
        //new Actions(driver).click(clickAuthorizeBtnEl).perform();
        clickAuthorizeBtnEl.isDisplayed();
        clickAuthorizeBtnEl.click();
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        Thread.sleep(20000);

        return this;

    }

    public Universal_Acc_TransactionByComCheckerPage clickSubmitBtn() throws InterruptedException {
        Thread.sleep(10000);
        clickSubmitButtonEl.isDisplayed();
        clickSubmitButtonEl.click();
        return this;

    }
    public Universal_Acc_TransactionByComCheckerPage clickRejectBtn() {
        clickRejectBtnEl.isDisplayed();
        clickRejectBtnEl.click();
        return this;

    }
    public Universal_Acc_TransactionByComCheckerPage fillRejectReason(String rejectReason) {
        fillRejectReasonEl.isDisplayed();
        clickRejectBtnEl.sendKeys(rejectReason);
        return this;

    }


}




