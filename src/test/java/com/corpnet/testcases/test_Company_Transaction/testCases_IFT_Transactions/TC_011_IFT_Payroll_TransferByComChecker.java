package com.corpnet.testcases.test_Company_Transaction.testCases_IFT_Transactions;
import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.IFT_TransactionByComCheckerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_011_IFT_Payroll_TransferByComChecker extends BaseTest {


        @Test
        public void authorizedIFT_Single_Bulk_TranShouldSuccess(ITestContext context) throws InterruptedException {

            String iftTranRef = (String) context.getAttribute("iftPayrollTrxReferenceNumber");

            IFT_TransactionByComCheckerPage iftTransactionByComCheckerPage
                        =page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getCheckerPayrollUser(),getPayrollPassword()).clickIFTCheckerQueue()
                        .searchIFTSingleBatchId(iftTranRef)
                        .clickAuthorizeBtn()
                        .clickSubmitBtn();
            Thread.sleep(3000);
            Assert.assertTrue(iftTransactionByComCheckerPage.hasSingleTranAuthorizedSuccess());

            System.out.println("Successfully fetched the Single IFT Ref:" + iftTranRef);
            Thread.sleep(5000);

        }


    }
