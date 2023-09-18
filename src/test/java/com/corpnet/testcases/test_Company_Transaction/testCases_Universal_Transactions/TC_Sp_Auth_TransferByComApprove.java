package com.corpnet.testcases.test_Company_Transaction.testCases_Universal_Transactions;

import com.corpnet.pages.Page;
import com.corpnet.pages.compay_Menu_Page.company_Approver_Menu_Pages.Universal_Acc_TransactionByComApprovePage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import com.corpnet.util.MockData;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Sp_Auth_TransferByComApprove extends BaseTest {

    @Test(priority = 0)
    public void approve_SpAuth_ThirdParty_ByApproveSuccess(ITestContext context) throws InterruptedException {

        String SpAuthRefId = (String) context.getAttribute("UniversalTrxReferenceNumber");
        Universal_Acc_TransactionByComApprovePage universalAccTransactionByComApprovePage=
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getSpAuthSingApproveUser(),getSpAuthMakerUserPass())
                        .clickUniversalApproveQueue()
               // .searchIFTBatchId(SpAuthRefId)
                .searchIFTBatchId(SpAuthRefId)
                .clickApproveBtn()
                .inputTokenNumber()
                .clickApproveTokenBtn()
                .clickYesBtn();
        MockData mockData = new MockData();
        mockData.updateToExcel(27, SpAuthRefId);

        System.out.println("Successfully get Approve Transaction Batch ID , Transaction Batch Id :- " +SpAuthRefId);
        Thread.sleep(10000);
    }

}
