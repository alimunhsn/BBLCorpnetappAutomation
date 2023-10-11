package com.corpnet.testcases.test_Company_Operations.TestCases_Company_Management.TestCases_CreateAccount;

import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.pages.operations_Checker_Menu_Pages.CPG_002_ApproveComAccountByCheckerPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_004_ApproveCompanyAccount extends BaseTest {

    @Test
    public void approveCompanyAccountSuccess(ITestContext context) throws InterruptedException {

        CPG_002_ApproveComAccountByCheckerPage cpg_002_approveComAccountByCheckerPage
                = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getCheckerUsername(), getOpsCheckerPassword())
                .clickCompanyAccountManageMenuForApprove()
                .clickCheckBoxForWaitingApprove()
                .searchCompany(getCompanyName())
                .clickDetailBtnAndCheckBoxForAll()
                .clickApproveBtn();
        Thread.sleep(3000);
        Assert.assertTrue(cpg_002_approveComAccountByCheckerPage.hasNewCompanyApproveSuccess());
        Thread.sleep(2000);
    }
}
