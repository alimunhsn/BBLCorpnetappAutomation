package com.corpnet.testcases.test_Company_Transaction.testCases_Payroll_Transactions;


import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.Payroll_TransactionByComCheckerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_032_Payroll_Bulk_TransferByComChecker extends BaseTest {


    @Test
    public void authorized_Bulk_Payroll_TranSuccess(ITestContext context) throws InterruptedException {
        String payrollRef = (String) context.getAttribute("payrollTrxReferenceNumber");
        Payroll_TransactionByComCheckerPage payrollTransactionByComCheckerPage =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getCheckerPayrollUser(), getPayrollPassword())
                        .clickPayrollCheckerQueue()

                        .searchIFTBatchId(payrollRef)
                        .clickAuthorizeBtn()
                        .clickSigRadioBtn()
                        .clickSubmitBtn();
        Assert.assertTrue(payrollTransactionByComCheckerPage.hasSingleTranAuthorizedSuccess());

        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + payrollRef);

        Thread.sleep(10000);

    }

}

