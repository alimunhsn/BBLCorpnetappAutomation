package com.corpnet.testcases.test_Company_Operations.TestCases_Company_Management.TestCases_CreateAccount;

import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.pages.operation_Maker_Menu_Pages.PG_002CreateComAccountManaByMakerPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_003_CreateCompanyAccount extends BaseTest {
    @Test
    public void showCompanyAccountDetailsAndCreateSuccess(ITestContext context) throws InterruptedException {
        String CompanyName = (String) context.getAttribute("NewCompanyName");
        PG_002CreateComAccountManaByMakerPage pg_002CreateComAccountManaByMakerPage =
                page.getInstance(CorpnetLoginPage.class)
                        .doLogin(getOpsMakerUser(), getOpsMakerPass())
                        .clickCompanyAccountManageMenu()
                        .clickRadioBtn()
                        .searchCompany(getCompanyName())
                        .ClickCompanyAccountBtn()
                        .clickCheckBoxCompanyAccount()
                        .selectTCSAAcc()
                        .clickSubmitBtn();
        Thread.sleep(3000);
        Assert.assertTrue(pg_002CreateComAccountManaByMakerPage.hasNewCompanyAccountSuccess());
        Thread.sleep(2000);
    }

}

