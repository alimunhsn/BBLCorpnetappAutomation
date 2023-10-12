package com.corpnet.testcases.test_Company_Transaction.testCases_RTGS_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.RTGS_BulkTransactionPageByComChecker;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_023_RTGS_Single_TransferByComChecker extends BaseTest {


    @Test(enabled = false)
    public void Authorized_RTGS_Single_TranSuccess(ITestContext context) throws InterruptedException {
        String rtgsTranRef = (String) context.getAttribute("TrxReferNumber");

        RTGS_BulkTransactionPageByComChecker rtgsBulkTransactionPageByComChecker = page.getInstance(CorpnetLoginPage.class)
        .doLogin(getTranMCUser(), getTranMCUserPass())
        .clickRTGSCheckerQueue()
        .searchIFTBatchId(rtgsTranRef)
        .clickAuthorizeBtn()
        .clickSubmitBtn();

       // Assert.assertTrue(rtgs_bulkTransactionPageByComChecker.hasSingleTranAuthorizedSuccess());
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + rtgsTranRef);

        Thread.sleep(5000);
    }

    @Test(enabled = true)
    public void Auth_Rtgs_Single_Tran(ITestContext context) throws InterruptedException {
        String refNo = (String) context.getAttribute("rtgsTrxReferenceNumber");
        RTGS_BulkTransactionPageByComChecker rtgsBulkTransactionPageByComChecker = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranMCUser(), getTranMCUserPass())
                .clickRTGSCheckerQueue()
                .searchIFTBatchId(refNo)
                .clickAuthorizeBtn()
                .clickSubmitBtn();
        Thread.sleep(4000);
        Assert.assertTrue(rtgsBulkTransactionPageByComChecker.hasSingleTranAuthorizedSuccess());
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + refNo);

        Thread.sleep(5000);
    }

}
