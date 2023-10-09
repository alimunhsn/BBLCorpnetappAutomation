package com.corpnet.testcases.test_Company_Transaction.testCases_EFT_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.EFT_TransactionByComApprovePage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import com.corpnet.util.MockData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_021_BEFTN_Multi_Bulk_TransferByComApprove extends BaseTest {


    @Test
    public void Approve_EFT_Multi_Bulk_TranSuccess(ITestContext context) throws InterruptedException {

        String EftRefNo = (String) context.getAttribute("EftTrxReferenceNumber");
        EFT_TransactionByComApprovePage eft_transactionByComApprovePage =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getTranCompAppUser(), getTranCompAppUserPass())
                        .clickEFTApproveQueue()
                        .searchIFTBatchId(EftRefNo)
                        .clickApproveBtn()
                        .clickOkkBtn()
                        .inputTokenNumber()
                        .clickApproveTokenBtn()
                        .clickYesBtn();
        Thread.sleep(4000);
        Assert.assertTrue(eft_transactionByComApprovePage.hasTransactionApprovedSuccess());
        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " + EftRefNo);
        MockData mockData = new MockData();
        mockData.updateToExcel(10, EftRefNo);
        mockData.updateDebitAccToExcel(10,eft_transactionByComApprovePage.debitAccount );
        Thread.sleep(10000);


    }
}
