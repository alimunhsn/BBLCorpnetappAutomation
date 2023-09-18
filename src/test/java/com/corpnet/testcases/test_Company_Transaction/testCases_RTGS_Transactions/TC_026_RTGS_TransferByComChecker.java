package com.corpnet.testcases.test_Company_Transaction.testCases_RTGS_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Checker_Menu_Pages.RTGS_BulkTransactionPageByComChecker;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_026_RTGS_TransferByComChecker extends BaseTest {

    @Test
    public void Authorized_RTGS_Bulk_TranSuccess(ITestContext context) throws InterruptedException {

        String rtgsRef = (String) context.getAttribute("rtgsTrxReferenceNumber");
        RTGS_BulkTransactionPageByComChecker rtgs_bulkTransactionPageByComChecker=page.getInstance(CorpnetLoginPage.class)
                .doLogin(getTranMCUser(), getTranMCUserPass())
                .clickRTGSCheckerQueue()
                .searchIFTBatchId("rtgsRef")
                .clickAuthorizeBtn()
                .clickSubmitBtn();
        System.out.println("Successfully get Transaction Id, Transaction Batch Id :- " + rtgsRef);

        Thread.sleep(10000);
    }

}
