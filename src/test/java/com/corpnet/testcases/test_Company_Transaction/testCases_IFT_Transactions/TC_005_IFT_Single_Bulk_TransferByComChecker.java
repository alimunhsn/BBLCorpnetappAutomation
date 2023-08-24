package com.corpnet.testcases.test_Company_Transaction.testCases_IFT_Transactions;
import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.IFT_TransactionByComCheckerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_005_IFT_Single_Bulk_TransferByComChecker extends BaseTest {


        @Test
        public void authorizedIFT_Single_Bulk_TranShouldSuccess(ITestContext context) throws InterruptedException {

            String iftTranRef = (String) context.getAttribute("IftTrxReferenceNumber");

            IFT_TransactionByComCheckerPage iftTransactionByComCheckerPage
                        =page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getTranMCUser(),getTranMCUserPass()).clickIFTCheckerQueue()
                        .searchIFTSingleBatchId(iftTranRef)
                        .clickAuthorizeBtn()
                        .clickSubmitBtn();
            Thread.sleep(5000);
            Assert.assertTrue(iftTransactionByComCheckerPage.hasSingleTranAuthorizedSuccess());

            System.out.println("Successfully fetched the Single IFT Ref:" + iftTranRef);
            Thread.sleep(5000);

        }


    }
