package com.corpnet.testcases.test_Company_Transaction.testCases_Payroll_Transactions;

import CorpNetApp.pom.base.BaseTest;
import CorpNetApp.pom.page.LoginPage.CompanyUsersLoginPage;
import CorpNetApp.pom.page.corpnet_Company_MenuPages.company_Maker_MenuPages.BulkPayrollTransactionPageByComMaker;
import CorpNetApp.pom.util.GeneralUtil;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_Pages.IFT_BulkTransactionByComMakerPage;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.Payroll_Pages.BulkPayrollTranByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_031_Payroll_Bulk_TransferByComMaker extends BaseTest {


    @Test
    public void initiate_Payroll_Bulk_TranSuccess(ITestContext context) throws InterruptedException, IOException {

        BulkPayrollTranByComMakerPage bulkPayrollTranByComMakerPage =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getMakerPayrollUser(), getPayrollPassword())
                        .clickPayrollBulk()
                        .paymentPurpose(1)
                        .selectMonth(2)
                        .selectYear(3)
                        .fileUpload(getPayrollBulkBulkFile())
                        .clickUploadBtn()
                        .clickConfirmBtn();
        Assert.assertTrue(bulkPayrollTranByComMakerPage.hasSingleTranInitiatedSuccess());

        String PayrollTrxReferenceNumber = bulkPayrollTranByComMakerPage.payrollBatch;

        context.setAttribute("payrollTrxReferenceNumber", PayrollTrxReferenceNumber);
        System.out.println("Successfully upload the IFT One To Many Transaction, Transaction Batch Id :- " + PayrollTrxReferenceNumber);
        Thread.sleep(5000);
    }

}