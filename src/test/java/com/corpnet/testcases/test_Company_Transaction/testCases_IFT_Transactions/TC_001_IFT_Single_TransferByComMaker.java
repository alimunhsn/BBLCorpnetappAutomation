package com.corpnet.testcases.test_Company_Transaction.testCases_IFT_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_Pages.SingleIFTTransactionByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_001_IFT_Single_TransferByComMaker extends BaseTest {


    @Test
    public void IFT_TransactionInitiateShouldSuccess(ITestContext context) throws InterruptedException {

        SingleIFTTransactionByComMakerPage singleIFTTransactionByComMakerPage
                = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranMCUser(), getTranMCUserPass()).clickSingleIFT()
                .selectComAcc(getSelectAccount())
                .selectBeneficiary(1)
                .fillTrxAmount()
                .fillTrxRemarks()
                .clickNextBtn()
                .clickConfirmBtn();

        Assert.assertTrue(singleIFTTransactionByComMakerPage.hasSingleTranInitiatedSuccess());

        String SingleIftTrxReferenceNumber = singleIFTTransactionByComMakerPage.SingleIftBatch;
        context.setAttribute("IftTrxReferenceNumber", SingleIftTrxReferenceNumber);
        System.out.println("Successfully upload the IFT One To Many Transaction, Transaction Batch Id :- " + SingleIftTrxReferenceNumber);
               // MockData mockData = new MockData();
     //   mockData.updateDebitAccToExcel(5,singleIFTTransactionByComMakerPage.selectComAcc());

        Thread.sleep(5000);

    }

}
