package com.corpnet.testcases.test_Company_Transaction.testCases_EFT_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.EFT_TransactionByComCheckerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class TC_017_BEFTN_Single_Bulk_TransferByComChecker extends BaseTest {


    @Test
    public void authorized_BEFTN_Single_Bulk_TranSuccess(ITestContext context) throws InterruptedException {
        String eftRef = (String) context.getAttribute("EftTrxReferenceNumber");
        EFT_TransactionByComCheckerPage eftTransactionByComCheckerPage =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getTranMCUser(), getTranMCUserPass())
                        .clickEFTCheckerQueue()
                        .searchIFTBatchId(eftRef)
                        .clickAuthorizeBtn()
                        .clickSubmitBtn();
        Assert.assertTrue(eftTransactionByComCheckerPage.hasBulkTranAuthorizedSuccess());
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + eftRef);

        Thread.sleep(30000);


    }

}
