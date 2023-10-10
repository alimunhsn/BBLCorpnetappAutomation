package com.corpnet.testcases.test_Company_Operations.TestCases_Company_Management.TestCases_CreateCompany;


import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.pages.operation_Maker_Menu_Pages.PG_001_CreateNewCompanyByMakerPage;
import com.corpnet.testcases.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_OP_001_CreateCompany extends BaseTest {


    public TC_OP_001_CreateCompany() {
        super();
    }


    @Test
    public void addNewCompanyShouldSuccess(ITestContext context) throws InterruptedException {

        PG_001_CreateNewCompanyByMakerPage pg_001_createNewCompanyByMakerPage =
                page.getInstance(CorpnetLoginPage.class).doLogin(getOpsMakerUser(), getOpsMakerPass())
                        .clickAddNewCompany()
                        .fillCompanyName(getCompanyName())
                        .fillCompanyCode()
                        .fillCompanyPhone("01730796749")
                        .fillCompanyEmail(getCompanyEmail())
                        .fillAddress("121/KHA,RAMPURA")
                        .fillCompanyCif(getCompanyCIF())
                        .fillContactPerson("Md Alimun Hasan")
                        .fillContactPhn("01915777041")
                        .ClickRadioButton()
                        .FillEmpId()
                        .fillRm("23852")
                        .ClickCreateBtn();
        Thread.sleep(5000);
        Assert.assertTrue(pg_001_createNewCompanyByMakerPage.hasNewCompanySuccess());
        String newCompanyName = getCompanyName();
        context.setAttribute("NewCompanyName", newCompanyName);
        System.out.println("Successfully Create a new company, Company Name:- " + newCompanyName);
        Thread.sleep(3000);

    }


}
