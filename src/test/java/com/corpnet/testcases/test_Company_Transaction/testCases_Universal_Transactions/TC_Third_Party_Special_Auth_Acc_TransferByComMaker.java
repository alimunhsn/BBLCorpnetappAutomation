package com.corpnet.testcases.test_Company_Transaction.testCases_Universal_Transactions;

import com.corpnet.pages.compay_Menu_Page.company_Maker_Menu_Pages.Universal_Acc_TranPages.Universal_Acc_TransferByComMakerPage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Third_Party_Special_Auth_Acc_TransferByComMaker extends BaseTest {


    @Test
    public void success_Special_Third_Acc_Transaction_initiate(ITestContext context) throws InterruptedException {
        Universal_Acc_TransferByComMakerPage universalAccTransferByComMakerPage =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getSpAuthMakerUser(), getSpAuthMakerUserPass())
                        .clickUniOwnAccBulk()
                        .selectAccountNo(getSelectAccount())
                        .uploadIFTFile()
                        .fillRemarks("Universal_Third_Account")
                        .clickUploadBtn()
                        .clickConfirmBtn();

        String universalTrxReferenceNumber = universalAccTransferByComMakerPage.UnBatchRef;
        context.setAttribute("UniversalTrxReferenceNumber", universalTrxReferenceNumber);
        System.out.println("Successfully upload the Universal Transaction, Transaction Batch Id :- " + universalTrxReferenceNumber);
        //    MockData mockData = new MockData();
        // mockData.updateToExcel(28,universalTrxReferenceNumber);
        Thread.sleep(5000);


    }

}
