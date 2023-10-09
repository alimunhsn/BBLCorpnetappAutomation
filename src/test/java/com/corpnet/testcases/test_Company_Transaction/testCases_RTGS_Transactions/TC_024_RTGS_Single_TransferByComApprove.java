package com.corpnet.testcases.test_Company_Transaction.testCases_RTGS_Transactions;
import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.RTGS_BulkTransactionPageByComApprover;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import com.corpnet.util.MockData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_024_RTGS_Single_TransferByComApprove extends BaseTest {

    @Test
    public void approve_Single_ByApproveSuccess(ITestContext context) throws InterruptedException {

        String rtgsRef = (String) context.getAttribute("rtgsTrxReferenceNumber");
        RTGS_BulkTransactionPageByComApprover rtgs_bulkTransactionPageByComApprover
                = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranCompAppUser(), getTranCompAppUserPass())
                .clickRTGSApproveQueue()
                .searchRTGSBatchId(rtgsRef)
                .clickApproveBtn()
                .inputTokenNumber()
                .clickApproveTokenBtn()
                .clickOkButton();
        Thread.sleep(3000);
        Assert.assertTrue(rtgs_bulkTransactionPageByComApprover.hasRTGSSingleTranApprovedSuccess());
        MockData mockData = new MockData();
        mockData.updateToExcel(14, rtgsRef);
        mockData.updateDebitAccToExcel(14, rtgs_bulkTransactionPageByComApprover.debitAccount);
        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " + rtgsRef);
        Thread.sleep(5000);
    }
}
