package com.corpnet.testcases.test_Company_Transaction.testCases_EFT_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.EFT_TransactionByComApprovePage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import com.corpnet.util.MockData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_018_BEFTN_Single_Bulk_Approve_TransferByComApprove extends BaseTest {


    @Test
    public void Approve_EFT_single_Bulk_TranApproveSuccess(ITestContext context) throws InterruptedException {

        String EftRef = (String) context.getAttribute("EftTrxReferenceNumber");
        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " + EftRef);
        EFT_TransactionByComApprovePage eft_transactionByComApprovePage =
                page.getInstance(CorpnetLoginPage.class).doLogin(getTranCompAppUser(), getTranCompAppUserPass())
                        .clickEFTApproveQueue()
                        .searchIFTBatchId(EftRef)
                        .clickApproveBtn()
                        .clickOkkBtn()
                        .inputTokenNumber()
                        .clickApproveTokenBtn()
                        .clickYesBtn();
        Assert.assertTrue(eft_transactionByComApprovePage.hasTransactionApprovedSuccess());
        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " + EftRef);
        MockData mockData = new MockData();
        mockData.updateToExcel(9, EftRef);
        mockData.updateDebitAccToExcel(9,eft_transactionByComApprovePage.debitAccount);
        Thread.sleep(10000);
    }
}
