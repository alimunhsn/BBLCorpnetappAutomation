package com.corpnet.pages;

import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.*;
import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.*;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.EFT_Pages.EFT_BulkTransactionByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.EFT_Pages.Single_EFT_TransactionByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_Pages.IFT_BulkTransactionByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_Pages.SingleIFTTransactionByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.Payroll_Pages.BulkPayrollTranByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.Payroll_Pages.Single_Payroll_TranByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.RTGS_Pages.RTGS_BulkTransactionByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.RTGS_Pages.RTGS_SingleTransactionByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.Universal_Acc_TranPages.Universal_Acc_TransferByComMakerPage;
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

    public RTGS_SingleTransactionByComMakerPage clickSingleRTGS() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.linkText("RTGS")).click();
        getWebElement(By.linkText("Single RTGS")).click();
        return getInstance(RTGS_SingleTransactionByComMakerPage.class);
    }

    public RTGS_BulkTransactionByComMakerPage clickRTGSBulk() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.linkText("RTGS")).click();
        getWebElement(By.linkText("Bulk RTGS")).click();
        return getInstance(RTGS_BulkTransactionByComMakerPage.class);
    }

    public RTGS_BulkTransactionPageByComApprover clickRTGSApproveQueue() {

        return getInstance(RTGS_BulkTransactionPageByComApprover.class);
    }

    public RTGS_BulkTransactionPageByComChecker clickRTGSCheckerQueue() throws InterruptedException {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.cssSelector("a[href$='controller/company-checker']")).click();
        Thread.sleep(5000);
        return getInstance(RTGS_BulkTransactionPageByComChecker.class);
    }

    public Single_Payroll_TranByComMakerPage clickSinglePayroll() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.linkText("Payroll")).click();
        getWebElement(By.linkText("Single IFT")).click();
        return getInstance(Single_Payroll_TranByComMakerPage.class);
    }

    public Payroll_TransactionByComCheckerPage clickPayrollCheckerQueue() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.cssSelector("a[href$='controller/company-checker']")).click();
        return getInstance(Payroll_TransactionByComCheckerPage.class);
    }

    public Payroll_TransactionByComApprovePage clickPayrollApproveQueue() {

        return getInstance(Payroll_TransactionByComApprovePage.class);
    }

    public BulkPayrollTranByComMakerPage clickPayrollBulk() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.linkText("EFT")).click();
        getWebElement(By.linkText("Bulk EFT")).click();
        return getInstance(BulkPayrollTranByComMakerPage.class);
    } public Universal_Acc_TransferByComMakerPage clickUniOwnAccBulk() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.linkText("Own Account Transfer")).click();
        getWebElement(By.cssSelector("ul li a[href$='/universalTrxUpload/universalUpload']")).click();
        return getInstance(Universal_Acc_TransferByComMakerPage.class);
    }

    public Universal_Acc_TransactionByComCheckerPage clickUniversalAccTranCheckerQueue() {

        new Actions(driver).click(TransactionModule).perform();
        getWebElement(By.cssSelector("a[href$='controller/company-checker']")).click();
        return getInstance(Universal_Acc_TransactionByComCheckerPage.class);
    }
    public Universal_Acc_TransactionByComApprovePage clickUniversalApproveQueue() {

        return getInstance(Universal_Acc_TransactionByComApprovePage.class);
    }


}
