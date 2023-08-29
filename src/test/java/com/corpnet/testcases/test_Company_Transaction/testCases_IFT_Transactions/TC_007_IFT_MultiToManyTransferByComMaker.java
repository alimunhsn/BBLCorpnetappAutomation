package com.corpnet.testcases.test_Company_Transaction.testCases_IFT_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_Pages.IFT_BulkTransactionByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_007_IFT_MultiToManyTransferByComMaker extends BaseTest {
    @Test
    public void initiateIFT_Multi_Bulk_TranSuccess(ITestContext context) throws InterruptedException {

        String IftMultiFilepath = System.getProperty("user.dir") + getIFTMultipleBulkFile();
        IFT_BulkTransactionByComMakerPage iftBulkTransactionByComMakerPage = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranMCUser(), getTranMCUserPass()).clickIFTBulk()
                .selectAccountNo(0)
                .uploadIFTMultiFile(IftMultiFilepath)
                .fillRemarks("IFT_ManyToMany_Transaction")
                .clickRadioMulti()
                .clickUploadBtn()
                .clickConfirmBtn();

        Assert.assertTrue(iftBulkTransactionByComMakerPage.hasMultiBulkTranInitiatedSuccess());
        String IFT1to1TrxReferenceNumber = iftBulkTransactionByComMakerPage.iftBatch;
        context.setAttribute("IftTrxReferenceNumber", IFT1to1TrxReferenceNumber);
        System.out.println("Successfully upload the IFT Multi To Many Transaction, Transaction Batch Id :- " + IFT1to1TrxReferenceNumber);
        Thread.sleep(10000);

    }
}
