package com.corpnet.pages;

import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.EFT_TransactionByComApprovePage;
import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.IFT_TransactionByComApprovePage;
import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.EFT_TransactionByComCheckerPage;
import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.IFT_TransactionByComCheckerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.EFT_Pages.EFT_BulkTransactionByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.EFT_Pages.Single_EFT_TransactionByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_Pages.IFT_BulkTransactionByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_Pages.SingleIFTTransactionByComMakerPage;
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

    //----#######---IFT Menu configure -----

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


    public Single_EFT_TransactionByComMakerPage clickSingleEFT() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.linkText("EFT")).click();
        getWebElement(By.linkText("Single EFT")).click();
        return getInstance(Single_EFT_TransactionByComMakerPage.class);
    }

    public EFT_BulkTransactionByComMakerPage clickEFTBulk() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.linkText("EFT")).click();
        getWebElement(By.linkText("Bulk EFT")).click();
        return getInstance(EFT_BulkTransactionByComMakerPage.class);
    }

    public EFT_TransactionByComCheckerPage clickEFTCheckerQueue() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.cssSelector("a[href$='controller/company-checker']")).click();
        return getInstance(EFT_TransactionByComCheckerPage.class);
    }

    public EFT_TransactionByComApprovePage clickEFTApproveQueue() {

        return getInstance(EFT_TransactionByComApprovePage.class);
    }


}
