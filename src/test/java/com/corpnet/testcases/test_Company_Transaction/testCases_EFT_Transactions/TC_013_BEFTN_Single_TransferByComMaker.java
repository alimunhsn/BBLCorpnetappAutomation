package com.corpnet.testcases.test_Company_Transaction.testCases_EFT_Transactions;

import com.corpnet.pages.Page;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.EFT_Pages.Single_EFT_TransactionByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_013_BEFTN_Single_TransferByComMaker extends BaseTest {


    @Test
    public void success_EFT_Single_Transaction_initiate(ITestContext context) throws InterruptedException {

        Single_EFT_TransactionByComMakerPage singleEftTransactionByComMakerPage =
                page.getInstance(CorpnetLoginPage.class).doLogin(getTranMCUser(),getTranMCUserPass()).clickSingleEFT()
                        .selectComAcc(getSelectAccount())
                        .selectBeneficiary(1)
                        .fillTrxAmount()
                        .fillTrxRemarks()
                        .clickNextBtn()
                        .clickConfirmBtn();
        Assert.assertTrue(singleEftTransactionByComMakerPage.hasSingleTranInitiatedSuccess());
        String SingleEftTrxReferenceNumber = singleEftTransactionByComMakerPage.SingleEftBatch;
        context.setAttribute("EftTrxReferenceNumber", SingleEftTrxReferenceNumber);
        System.out.println("Successfully initiated the EFT Transaction, Transaction Batch Id :- " + SingleEftTrxReferenceNumber);
        Thread.sleep(10000);

    }


}
