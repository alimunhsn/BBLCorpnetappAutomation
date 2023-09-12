package com.corpnet.testcases.test_Company_Transaction.testCases_Payroll_Transactions;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.Payroll_Pages.Single_Payroll_TranByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TC_028_PayrollSingle_TransferByComMaker extends BaseTest {
    public TC_028_PayrollSingle_TransferByComMaker() {
        super();
    }

    @Test
    public void initiate_Payroll_Single_TranSuccess(ITestContext context) throws InterruptedException, FileNotFoundException {
       //int CompAcc=System.getProperty("user.dir") + getSelectAccount()

        Single_Payroll_TranByComMakerPage single_payroll_tranByComMakerPage=
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getMakerPayrollUser(),getPayrollPassword()).clickSinglePayroll()
                .selectComAcc(getSelectAccount())
                .selectBeneficiary(0)
                .fillTrxAmount()
                .fillTrxRemarks()
                .clickNextBtn()
                .clickConfirmBtn();

        Assert.assertTrue(single_payroll_tranByComMakerPage.hasSingleTranInitiatedSuccess());
        String PayrollTrxReferenceNumber = single_payroll_tranByComMakerPage.PayrollTrxRefNo;
        context.setAttribute("payrollTrxReferenceNumber",PayrollTrxReferenceNumber);
        System.out.println("Successfully upload the RTGS Transaction, Transaction Batch Id :- " + PayrollTrxReferenceNumber);
        Thread.sleep(10000);

    }
}

