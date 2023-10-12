package com.corpnet.testcases.test_Company_Transaction.testCases_RTGS_Transactions;


import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.RTGS_Pages.RTGS_SingleTransactionByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TC_022_RTGS_Single_TransferByComMaker extends BaseTest {
    @Test
    public void initiateRTGS_Single_TranSuccess(ITestContext context) throws InterruptedException, FileNotFoundException {
        RTGS_SingleTransactionByComMakerPage rtgs_singleTransactionByComMakerPage =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getTranMCUser(), getTranMCUserPass())
                        .clickSingleRTGS()
                        .selectBeneficiary(1)
                        .fillAmount("100000")
                        .fillRemarks("RTGS_Single_Transaction")
                        .nextButton()
                        .confirmButton();
        Assert.assertTrue(rtgs_singleTransactionByComMakerPage.hasSingleRTGS_TranInitiatedSuccess());
        String RTGSTrxReferenceNumber = rtgs_singleTransactionByComMakerPage.SingleIftBatch;
        context.setAttribute("rtgsTrxReferenceNumber", RTGSTrxReferenceNumber);
        System.out.println("Successfully upload the RTGS Transaction, Transaction Batch Id :- " + RTGSTrxReferenceNumber);
        Thread.sleep(5000);

    }
}

