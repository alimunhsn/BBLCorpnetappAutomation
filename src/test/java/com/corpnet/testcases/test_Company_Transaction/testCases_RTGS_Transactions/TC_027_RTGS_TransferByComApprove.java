package com.corpnet.testcases.test_Company_Transaction.testCases_RTGS_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.RTGS_BulkTransactionPageByComApprover;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import com.corpnet.util.MockData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_027_RTGS_TransferByComApprove extends BaseTest {
    @Test
    public void Rtgs_ApproveByApproveShouldSuccess(ITestContext context) throws InterruptedException {

        String rtgsRef = (String) context.getAttribute("rtgsTrxReferenceNumber");
        RTGS_BulkTransactionPageByComApprover rtgs_bulkTransactionPageByComApprover =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getTranMCUser(), getTranMCUserPass())
                        .clickRTGSApproveQueue()
                        .searchRTGSBatchId(rtgsRef)
                        .clickApproveBtn()
                        .inputTokenNumber()
                        .clickApproveBtn()
                        .clickOkButton();
        Assert.assertTrue(rtgs_bulkTransactionPageByComApprover.hasRTGSSingleTranApprovedSuccess());

        MockData mockData = new MockData();
        mockData.updateToExcel(15, rtgsRef);
        mockData.updateDebitAccToExcel(15, rtgs_bulkTransactionPageByComApprover.debitAccount);
        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " + rtgsRef);
        Thread.sleep(10000);
    }
}
