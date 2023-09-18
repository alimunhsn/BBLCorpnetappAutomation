package com.corpnet.testcases.testLogin;

import com.corpnet.pages.HomePage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import com.corpnet.testcases.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginTest extends BaseTest {
    @Test
    public void loginShouldSuccess() {
        HomePage homePage = page.getInstance(CorpnetLoginPage.class)
                .fillUsername(getTranMCUser())
                .fillPassword(getTranMCUserPass())
                .clickLoginBtn();
        Assert.assertTrue(homePage.hasLogoutLink());

    }
    @Test
    public void loginShouldFailWithInvalidUserPass(){
        CorpnetLoginPage loginPage=page.getInstance(CorpnetLoginPage.class)
                .fillUsername("test")
                .fillPassword("12423")
                .clickLoginBtnToFail();
        Assert.assertTrue(loginPage.hasError());


    }
}
