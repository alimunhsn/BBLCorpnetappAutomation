package com.corpnet.testcases.test_Company_Transaction.testCases_Payroll_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.Payroll_TransactionByComApprovePage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import com.corpnet.util.MockData;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_033_Payroll_Bulk_TransferByComApprover extends BaseTest {


    @Test
    public void Approve_Bulk_Payroll_TranSuccess(ITestContext context) throws InterruptedException {

        String payrollRef = (String) context.getAttribute("payrollTrxReferenceNumber");
        System.out.println("Successfully get Approve Transaction Payroll Batch ID , Transaction Batch Id :- " + payrollRef);
        Payroll_TransactionByComApprovePage payroll_transactionByComApprovePage =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getApprovePayrollUser(), getPayrollPassword())
                        .clickPayrollApproveQueue()
                        .searchIFTBatchId(payrollRef)
                        .clickApproveBtn()
                        .inputTokenNumber()
                        .clickApproveTokenBtn()
                        .clickYesBtn();


        System.out.println("Successfully get Approve Transaction Payroll Batch ID , Transaction Batch Id :- " + payrollRef);
        MockData mockData = new MockData();
        mockData.updateToExcel(54, payrollRef);
        Thread.sleep(5000);
    }


}
