package com.corpnet.testcases.test_Company_Transaction.testCases_IFT_Transactions;
import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.IFT_Pages.IFT_BulkTransactionByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class TC_010_IFT_Payroll_Bulk_TransferByComMaker extends BaseTest {

    @Test
    public void initiateIFT_Payroll_TranSuccess(ITestContext context) throws InterruptedException {
        String IftPayrollFilepath = System.getProperty("user.dir") + getPayrollBulkBulkFile();
        IFT_BulkTransactionByComMakerPage iftBulkTransactionByComMakerPage =
                page.getInstance(CorpnetLoginPage.class).doLogin(getMakerPayrollUser(), getPayrollPassword()).clickIFTBulk()
                        .selectAccountNo(0)
                        .SelectPayrollRadioButton()
                        .SelectPayrollPurpose()
                        .uploadIFTFile(IftPayrollFilepath)
                        .clickUploadBtn()
                        .clickPayrollConfirmBtn();
        Thread.sleep(1500);
        Assert.assertTrue(iftBulkTransactionByComMakerPage.hasSingleBulkTranInitiatedSuccess());
        String IFTPayrollReferenceNumber = iftBulkTransactionByComMakerPage.iftPayrollBatch;
        context.setAttribute("iftPayrollTrxReferenceNumber", IFTPayrollReferenceNumber);
        System.out.println("Successfully upload the IFT payroll Transaction, Transaction Batch Id :- " + IFTPayrollReferenceNumber);

        Thread.sleep(10000);

    }

}
