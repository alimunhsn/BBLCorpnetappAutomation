package com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages;


import com.corpnet.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.time.Duration;

public class DD_TransactionByComCheckerPage extends BasePage {
    public String DDRefID;


    @FindBy(css = "div label input[aria-controls='dataTables-own']")
    WebElement fillDDBatchIdEl;

    @FindBy(css = "div tbody button[onclick*='authorizeClickForDD']")
    WebElement clickAuthorizeBtnEl;

    @FindBy(id = "idSubmitButton")
    WebElement clickSubmitButtonEl;

    @FindBy(id = "idRejectButton")
    WebElement clickRejectBtnEl;

    @FindBy(css = "input#idRejectionReason")
    WebElement fillRejectReasonEl;

    @FindBy(id = "messageModalCancleTransactionYesAll")
    WebElement clickYesButtonEl;

    public DD_TransactionByComCheckerPage(WebDriver driver) {
        super(driver);
    }

    public DD_TransactionByComCheckerPage searchDDBatchId(String DDRefID) throws InterruptedException {
        fillDDBatchIdEl.isDisplayed();
        //iftBatchId = fillIftBatchIdEl.getText();
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " +DDRefID);
        fillDDBatchIdEl.sendKeys(DDRefID);

//        fillIftBatchIdEl.sendKeys();
        Thread.sleep(2000);
        return this;
    }


    public DD_TransactionByComCheckerPage clickAuthorizeBtn() throws InterruptedException {
        //new Actions(driver).click(clickAuthorizeBtnEl).perform();
        clickAuthorizeBtnEl.isDisplayed();
        clickAuthorizeBtnEl.click();
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        Thread.sleep(10000);

        return this;

    }

    public DD_TransactionByComCheckerPage clickSubmitBtn() throws InterruptedException {
        Thread.sleep(10000);
        clickSubmitButtonEl.isDisplayed();
        clickSubmitButtonEl.click();
        return this;

    }
    public DD_TransactionByComCheckerPage clickRejectBtn() {
        clickRejectBtnEl.isDisplayed();
        clickRejectBtnEl.click();
        return this;

    }
    public DD_TransactionByComCheckerPage fillRejectReason(String rejectReason) {
        fillRejectReasonEl.isDisplayed();
        clickRejectBtnEl.sendKeys(rejectReason);
        return this;

    }


}




