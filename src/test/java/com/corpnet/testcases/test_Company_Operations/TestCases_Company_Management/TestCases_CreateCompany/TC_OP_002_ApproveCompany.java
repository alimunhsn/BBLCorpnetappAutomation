package com.corpnet.testcases.test_Company_Operations.TestCases_Company_Management.TestCases_CreateCompany;

import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.pages.operations_Checker_Menu_Pages.UnauthorizedCompaniesByCheckerPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_OP_002_ApproveCompany extends BaseTest {

    @Test
    public void unauthorizedCompanyAuthorizeSuccess(ITestContext context) throws InterruptedException {
        //context.getAttribute("NewCompanyName");


        UnauthorizedCompaniesByCheckerPage unauthorizedCompaniesByCheckerPage =
                page.getInstance(CorpnetLoginPage.class).doLogin(getCheckerUsername(), getOpsCheckerPassword())
                        .clickUnAuthorizedCompany()
                        .companySearch(getCompanyName())
                        .clickDetailsBtn()
                        .clickSubBtn();
        Thread.sleep(3000);
        Assert.assertTrue(unauthorizedCompaniesByCheckerPage.hasNewCompanyAuthorizeSuccess());
        String company = getCompanyName();
        System.out.println("company  " + company);
        Thread.sleep(50000);


    }
}
