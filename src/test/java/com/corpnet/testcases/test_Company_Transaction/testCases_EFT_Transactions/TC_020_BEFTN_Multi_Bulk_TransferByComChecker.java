package com.corpnet.testcases.test_Company_Transaction.testCases_EFT_Transactions;


import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.EFT_TransactionByComCheckerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

;

public class TC_020_BEFTN_Multi_Bulk_TransferByComChecker extends BaseTest {


    @Test()
    public void authorized_EFT_Multi_Bulk_TranSuccess(ITestContext context) throws InterruptedException {

        String eftRef = (String) context.getAttribute("EftTrxReferenceNumber");
        EFT_TransactionByComCheckerPage eft_transactionByComCheckerPage =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getTranMCUser(), getTranMCUserPass())
                        .clickEFTCheckerQueue()
                        .searchIFTBatchId(eftRef)
                        .clickAuthorizeBtn()
                        .clickSubmitBtn();
        Assert.assertTrue(eft_transactionByComCheckerPage.hasBulkTranAuthorizedSuccess());
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + eftRef);
        Thread.sleep(5000);


    }

}
