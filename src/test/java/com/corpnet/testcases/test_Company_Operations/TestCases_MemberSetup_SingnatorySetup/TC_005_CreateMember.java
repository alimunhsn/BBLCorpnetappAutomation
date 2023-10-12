package com.corpnet.testcases.test_Company_Operations.TestCases_MemberSetup_SingnatorySetup;

import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.pages.operation_Maker_Menu_Pages.PG_003_MemberSetupByMakerPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_005_CreateMember extends BaseTest {

    @Test(priority = 0)
    public void CreateMemberSetupSuccess() throws InterruptedException {
            PG_003_MemberSetupByMakerPage pg_003_memberSetupByMakerPage
                    = page.getInstance(CorpnetLoginPage.class)
                    .doLogin(getOpsMakerUser(), getOpsMakerPass())
                    .selectMemberSetupMenu()
                    .selectCompany()
                    .SearchCompany(getCompanyName())
                    .clickCompany()
                    .selectMemberGroupA()
                    .FillComDivision("Dhaka")
                    .fillMemberID()
                    .fillEmail(getCompanyEmail())
                    .fillMob("01730796759")
                    .fillAddress("121/K,Banasree,Dhaka-1219")
                    .fillMemberName(getMemberNameA())
                    .fillDesignation("SQA")
                    .clickMemberSetupPurpose()
                    .clickCreateBtn();
            Thread.sleep(4000);
            Assert.assertTrue(pg_003_memberSetupByMakerPage.MemberCreateSuccess());
            Thread.sleep(2000);


    }

    @Test(priority = 1)
    public void CreateMemberSetupGroupBSuccess() throws InterruptedException {

        PG_003_MemberSetupByMakerPage pg_003_memberSetupByMakerPage
                = page.getInstance(CorpnetLoginPage.class)
                .doLogin(getOpsMakerUser(), getOpsMakerPass())
                .selectMemberSetupMenu()
                .selectCompany()
                .SearchCompany(getCompanyName())
                .clickCompany()
                .selectMemberGroupB()
                .FillComDivision("Dhaka")
                .fillMemberID()
                .fillEmail(getCompanyEmail())
                .fillMob("01730796759")
                .fillAddress("121/K,Banasree,Dhaka-1219")
                .fillMemberName(getMemberNameB())
                .fillDesignation("SQA")
                .clickMemberSetupPurpose()
                .clickCreateBtn();
        Thread.sleep(4000);
        Assert.assertTrue(pg_003_memberSetupByMakerPage.MemberCreateSuccess());
        Thread.sleep(2000);

    }

}
