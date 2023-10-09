package com.corpnet.testcases.test_Company_Transaction.testCases_EFT_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.EFT_Pages.EFT_BulkTransactionByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_019_BEFTN_Multi_Bulk_TransferByComMaker extends BaseTest {


    @Test
    public void success_EFT_Multi_bulk_Transaction_initiate(ITestContext context) throws InterruptedException {
        String EFTMultipleBulkFile = System.getProperty("user.dir") + getEFTMultipleBulkFile();
        EFT_BulkTransactionByComMakerPage eft_bulkTransactionByComMakerPage =
                page.getInstance(CorpnetLoginPage.class).doLogin(getTranMCUser(), getTranMCUserPass())
                        .clickEFTBulk()
                        .selectAccountNo(getSelectAccount())
                        .uploadIFTMultiFile(EFTMultipleBulkFile)
                        .fillRemarks("EFT_Many_To_Many")
                        .clickRadioMulti()
                        .clickUploadBtn()
                        .clickConfirmBtn();
        Thread.sleep(3000);
        Assert.assertTrue(eft_bulkTransactionByComMakerPage.hasBulkTranInitiatedSuccess());
        String eftTrxReferenceNumber = eft_bulkTransactionByComMakerPage.EftBatchRef;
        context.setAttribute("EftTrxReferenceNumber", eftTrxReferenceNumber);
        System.out.println("Successfully upload the EFT One To Many Transaction, Transaction Batch Id :- " + eftTrxReferenceNumber);
        Thread.sleep(10000);

    }


}
