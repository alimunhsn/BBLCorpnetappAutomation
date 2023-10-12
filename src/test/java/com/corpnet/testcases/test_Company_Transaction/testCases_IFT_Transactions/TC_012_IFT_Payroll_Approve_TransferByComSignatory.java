package com.corpnet.testcases.test_Company_Transaction.testCases_IFT_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.IFT_TransactionByComApprovePage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import com.corpnet.util.MockData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_012_IFT_Payroll_Approve_TransferByComSignatory extends BaseTest {
    @Test(enabled = false)
    public void Approve_IFT_Single_TranShouldSuccess(ITestContext context) throws InterruptedException {

        String iftRef = (String) context.getAttribute("IftTrxReferenceNumber");
        IFT_TransactionByComApprovePage ift_transactionByComApprovePage = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranCompAppUser(), getTranCompAppUserPass())
                .clickIFTApproveQueue()
                .searchIFTBatchId(iftRef)
                .clickApproveBtn()
                .inputTokenNumber()
                .clickApproveTokenBtn()
                .clickYesBtn();
        Thread.sleep(3000);
        Assert.assertTrue(ift_transactionByComApprovePage.hasSingleTranApprovedSuccess());
        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " + iftRef);
        MockData mockData = new MockData();
        mockData.updateToExcel(2, iftRef);
        Thread.sleep(5000);

    }

    @Test(enabled = false)
    public void Approve_IFT_SingleBulk_TranShouldSuccess(ITestContext context) throws InterruptedException {

        String iftRef = (String) context.getAttribute("IftTrxReferenceNumber");
        IFT_TransactionByComApprovePage ift_transactionByComApprovePage = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranCompAppUser(), getTranCompAppUserPass())
                .clickIFTApproveQueue()
                .searchIFTBatchId(iftRef)
                .clickApproveBtn()
                .inputTokenNumber()
                .clickApproveTokenBtn()
                .clickYesBtn();
        Thread.sleep(5000);
        Assert.assertTrue(ift_transactionByComApprovePage.hasSingleTranApprovedSuccess());
        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " + iftRef);
        MockData mockData = new MockData();
        mockData.updateToExcel(3, iftRef);
        Thread.sleep(5000);

    }

    @Test(enabled = false)
    public void Approve_IFT_MultiBulk_TranShouldSuccess(ITestContext context) throws InterruptedException {

        String iftRef = (String) context.getAttribute("IftTrxReferenceNumber");
        IFT_TransactionByComApprovePage ift_transactionByComApprovePage = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranCompAppUser(), getTranCompAppUserPass())
                .clickIFTApproveQueue()
                .searchIFTBatchId(iftRef)
                .clickApproveBtn()
                .inputTokenNumber()
                .clickApproveTokenBtn()
                .clickYesBtn();
        Thread.sleep(5000);
        Assert.assertTrue(ift_transactionByComApprovePage.hasSingleTranApprovedSuccess());
        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " + iftRef);
        MockData mockData = new MockData();
        mockData.updateToExcel(4, iftRef);
        Thread.sleep(5000);

    }
    @Test(enabled = true)
    public void Approve_IFT_Payroll_Bulk_TranShouldSuccess(ITestContext context) throws InterruptedException {

        String iftRef = (String) context.getAttribute("iftPayrollTrxReferenceNumber");
        IFT_TransactionByComApprovePage ift_transactionByComApprovePage = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranCompAppUser(), getTranCompAppUserPass())
                .clickIFTApproveQueue()
                .searchIFTBatchId(iftRef)
                .clickApproveBtn()
                .inputTokenNumber()
                .clickApproveTokenBtn()
                .clickYesBtn();
        Thread.sleep(5000);
        Assert.assertTrue(ift_transactionByComApprovePage.hasSingleTranApprovedSuccess());
        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " + iftRef);
        MockData mockData = new MockData();
        mockData.updateToExcel(5, iftRef);
        Thread.sleep(5000);

    }

}
