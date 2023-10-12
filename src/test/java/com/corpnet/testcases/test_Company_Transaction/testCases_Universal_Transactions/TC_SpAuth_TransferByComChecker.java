package com.corpnet.testcases.test_Company_Transaction.testCases_Universal_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.Universal_Acc_TransactionByComCheckerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_SpAuth_TransferByComChecker extends BaseTest {
    @Test(priority = 0)
    public void Authorized_Own_Bulk_TranSuccess(ITestContext context) throws InterruptedException {

        String SpAuthBatchId = (String) context.getAttribute("UniversalTrxReferenceNumber");
        Universal_Acc_TransactionByComCheckerPage universalAccTransactionByComCheckerPage =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getSpAuthCheckerUser(), getSpAuthMakerUserPass())
                        .clickUniversalAccTranCheckerQueue()
                        .searchSpAuthBatchId(SpAuthBatchId)
                        .clickAuthorizeBtn()
                        .clickSubmitBtn();


        System.out.println("Successfully get Transaction Id, Transaction Special Auth Batch Id :- " + SpAuthBatchId);

        Thread.sleep(10000);
    }
    @Test(enabled = false)
    public void Authorized_SpAuth_Bulk_TranSuccess(ITestContext context) throws InterruptedException {

        String SpAuthBatchId = (String) context.getAttribute("UniversalTrxReferenceNumber");
        Universal_Acc_TransactionByComCheckerPage universalAccTransactionByComCheckerPage =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getSpAuthCheckerUser(), getSpAuthMakerUserPass())
                        .clickUniversalAccTranCheckerQueue()
                        .searchSpAuthBatchId(SpAuthBatchId)
                        .clickAuthorizeBtn()
                        .clickSubmitBtn();

        System.out.println("Successfully get Transaction Id, Transaction Special Auth Batch Id :- " + SpAuthBatchId);

        Thread.sleep(10000);
    }

}
