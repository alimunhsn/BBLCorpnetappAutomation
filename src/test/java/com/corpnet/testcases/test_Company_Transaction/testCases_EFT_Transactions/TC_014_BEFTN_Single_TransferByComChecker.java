package com.corpnet.testcases.test_Company_Transaction.testCases_EFT_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.EFT_TransactionByComCheckerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_014_BEFTN_Single_TransferByComChecker extends BaseTest {
    @Test
    public void authorizedEFT_Single_TranSuccess(ITestContext context) throws InterruptedException {
        String eftSingleRef = (String) context.getAttribute("EftTrxReferenceNumber");
        EFT_TransactionByComCheckerPage eftTransactionByComCheckerPage = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranMCUser(), getTranMCUserPass()).clickEFTCheckerQueue()
                .searchIFTBatchId(eftSingleRef)
                .clickAuthorizeBtn()
                .clickSubmitBtn();
        Thread.sleep(4000);
        Assert.assertTrue(eftTransactionByComCheckerPage.hasSingleTranAuthorizedSuccess());
        System.out.println("Successfully fetched the Single IFT Ref:" + eftSingleRef);
        Thread.sleep(5000);

    }

}

