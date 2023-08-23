package com.corpnet.pages;

import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.IFT_TransactionByComApprovePage;
import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.IFT_TransactionByComCheckerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_BulkTransactionByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.SingleIFTTransactionByComMakerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    WebElement TransactionModule = driver.findElement(By.linkText("Transaction"));


    public boolean hasLogoutLink() {
        return getWebElements(By.linkText("LOG OUT")).size() > 0;
    }

    //IFT Menu configure -----

    public SingleIFTTransactionByComMakerPage clickSingleIFT() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.linkText("IFT")).click();
        getWebElement(By.linkText("Single IFT")).click();
        return getInstance(SingleIFTTransactionByComMakerPage.class);
    }

    public IFT_BulkTransactionByComMakerPage clickIFTBulk() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.linkText("IFT")).click();
        getWebElement(By.linkText("Bulk IFT")).click();
        return getInstance(IFT_BulkTransactionByComMakerPage.class);
    }

    public IFT_TransactionByComCheckerPage clickIFTCheckerQueue() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.cssSelector("a[href$='controller/company-checker']")).click();
        return getInstance(IFT_TransactionByComCheckerPage.class);
    }

    public IFT_TransactionByComApprovePage clickIFTApproveQueue() {

        return getInstance(IFT_TransactionByComApprovePage.class);
    }

}
