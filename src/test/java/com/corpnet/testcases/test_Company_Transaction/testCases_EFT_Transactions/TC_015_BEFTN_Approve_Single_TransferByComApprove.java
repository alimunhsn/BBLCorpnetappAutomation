package com.corpnet.testcases.test_Company_Transaction.testCases_EFT_Transactions;


import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.EFT_TransactionByComApprovePage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import com.corpnet.util.MockData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_015_BEFTN_Approve_Single_TransferByComApprove extends BaseTest {


    @Test
    public void Approve_EFT_Single_TranSuccess(ITestContext context) throws InterruptedException {

       // String eftSingleRef = (String) context.getAttribute("singleEftTrxReferenceNumber");
        String eftSingleRef = (String) context.getAttribute("EftTrxReferenceNumber");

        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " + eftSingleRef);
       EFT_TransactionByComApprovePage eft_transactionByComApprovePage=page.getInstance(CorpnetLoginPage.class)
               .doLogin(getTranCompAppUser(),getTranCompAppUserPass()).clickEFTApproveQueue()
                .searchIFTBatchId(eftSingleRef)
                .clickApproveBtn()
                .clickOkkBtn()
                .inputTokenNumber()
                .clickApproveTokenBtn()
                .clickYesBtn();
        Assert.assertTrue(eft_transactionByComApprovePage.hasTransactionApprovedSuccess());
        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " + eftSingleRef);
        MockData mockData=new MockData();
        mockData.updateToExcel(8,eftSingleRef);
        mockData.updateDebitAccToExcel(8,eft_transactionByComApprovePage.debitAccount);
        Thread.sleep(10000);
    }



}
