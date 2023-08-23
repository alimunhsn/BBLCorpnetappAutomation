package com.corpnet.testcases.test_Company_Transaction.testCases_IFT_Transactions;


import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_BulkTransactionByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class TC_003_IFT_SingleBulkTranByComMaker extends BaseTest {


    @Test
    public void initiateIFT_OneToMany_TranSuccess(ITestContext context) throws InterruptedException {
        String IftSingleFilepath =System.getProperty("user.dir")+getIFTSingleBulkFile();
        IFT_BulkTransactionByComMakerPage iftBulkTransactionByComMakerPage=page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranMCUser(),getTranMCUserPass()).clickIFTBulk()
                .selectAccountNo(getSelectAccount())
                .uploadIFTFile(IftSingleFilepath)
                .fillRemarks("IFT_OneToMany_Transaction")
                .clickUploadBtn()
                .clickConfirmBtn();

        Assert.assertTrue(iftBulkTransactionByComMakerPage.hasSingleBulkTranInitiatedSuccess());
        String IFT1to1TrxReferenceNumber = iftBulkTransactionByComMakerPage.iftBatch;
        context.setAttribute("IftTrxReferenceNumber", IFT1to1TrxReferenceNumber);
        System.out.println("Successfully upload the IFT One To Many Transaction, Transaction Batch Id :- " + IFT1to1TrxReferenceNumber);

        Thread.sleep(10000);

    }


}
