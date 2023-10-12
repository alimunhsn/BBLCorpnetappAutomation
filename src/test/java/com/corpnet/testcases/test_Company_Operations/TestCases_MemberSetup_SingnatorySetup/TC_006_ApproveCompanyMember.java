package com.corpnet.testcases.test_Company_Operations.TestCases_MemberSetup_SingnatorySetup;

import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.pages.operations_Checker_Menu_Pages.CPG_003_MemberApproveByCheckerSummaryPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_006_ApproveCompanyMember extends BaseTest {

    @Test(priority = 3)
    public void approveComMemberApproveSuccess() throws InterruptedException {
        CPG_003_MemberApproveByCheckerSummaryPage cpg_003_memberApproveByCheckerSummaryPage
                = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getCheckerUsername(), getOpsCheckerPassword()).clickMemberSummary()
                .clickSearchBtn()
                .clickUnAuthorizeCheckBox()
                .clickDetailsBtn()
                .checkAllCompany()
                .clickSubBtn();

        Thread.sleep(2000);
        Assert.assertTrue(cpg_003_memberApproveByCheckerSummaryPage.MemberAuthSuccess());
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void approveGroup_B_ComMemberApproveSuccess() throws InterruptedException {
        CPG_003_MemberApproveByCheckerSummaryPage cpg_003_memberApproveByCheckerSummaryPage
                = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getCheckerUsername(), getOpsCheckerPassword()).clickMemberSummary()
                .clickSearchBtn()
                .clickUnAuthorizeCheckBox()
                .clickDetailsBtn()
                .checkAllCompany()
                .clickSubBtn();
        Thread.sleep(2000);
        Assert.assertTrue(cpg_003_memberApproveByCheckerSummaryPage.MemberAuthSuccess());
        Thread.sleep(5000);
    }

}
