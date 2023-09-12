package com.corpnet.testcases.test_Company_Transaction.testCases_RTGS_Transactions;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.RTGS_Pages.RTGS_BulkTransactionByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_025_RTGS_Bulk_TransferByComMaker extends BaseTest {

    @Test()
    public void initiate_RTGS_Bulk_TranSuccess(ITestContext context) throws InterruptedException, IOException {
        RTGS_BulkTransactionByComMakerPage rtgs_bulkTransactionByComMakerPage
                = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranMCUser(), getTranMCUserPass())
                .clickRTGSBulk()
                .selectAccountNo(0)
                .uploadIFTFile()
                .fillRemarks("RTGS_Bulk_Transaction")
                .clickUploadBtn()
                .clickConfirmBtn();
        Assert.assertTrue(rtgs_bulkTransactionByComMakerPage.hasRTGS_Bulk_TranInitiatedSuccess());
        String RTGSTrxReferenceNumber = rtgs_bulkTransactionByComMakerPage.rtgsBatchRef;
        context.setAttribute("rtgsTrxReferenceNumber", RTGSTrxReferenceNumber);
        System.out.println("Successfully upload the IFT One To Many Transaction, Transaction Batch Id :- " + RTGSTrxReferenceNumber);


        Thread.sleep(5000);
    }
}