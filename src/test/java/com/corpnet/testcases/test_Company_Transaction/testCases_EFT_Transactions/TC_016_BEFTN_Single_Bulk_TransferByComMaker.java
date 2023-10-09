package com.corpnet.testcases.test_Company_Transaction.testCases_EFT_Transactions;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.EFT_Pages.EFT_BulkTransactionByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import com.corpnet.util.MockData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_016_BEFTN_Single_Bulk_TransferByComMaker extends BaseTest {

    @Test
    public void success_EFT_Single_Bulk_Transaction_initiate(ITestContext context) throws InterruptedException {
       String EFTSingleFile=System.getProperty("user.dir") +getEFTSingleBulkFile();

        EFT_BulkTransactionByComMakerPage eft_bulkTransactionByComMakerPage =
                page.getInstance(CorpnetLoginPage.class).doLogin(getTranMCUser(), getTranMCUserPass())
                        .clickEFTBulk()
                        .selectAccountNo(getSelectAccount())
                        .uploadIFTFile(EFTSingleFile)
                        .fillRemarks("EFT_Single_To_Many")
                        .clickUploadBtn()
                        .clickConfirmBtn();
        Thread.sleep(3000);
        Assert.assertTrue(eft_bulkTransactionByComMakerPage.hasBulkTranInitiatedSuccess());
        String eftTrxReferenceNumber = eft_bulkTransactionByComMakerPage.EftBatchRef;
        context.setAttribute("EftTrxReferenceNumber", eftTrxReferenceNumber);
        System.out.println("Successfully upload the EFT One To Many Transaction, Transaction Batch Id :- " + eftTrxReferenceNumber);
        MockData mockData = new MockData();
        mockData.updateToExcel(9, eftTrxReferenceNumber);
        Thread.sleep(5000);

    }

}
