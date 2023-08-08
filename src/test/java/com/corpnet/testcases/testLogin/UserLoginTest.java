package com.corpnet.testcases.testLogin;

import com.corpnet.pages.HomePage;
import com.corpnet.pages.loginPages.CorpnetLoginPage;
import com.corpnet.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginTest extends BaseTest {
    @Test
    public void loginShouldSuccess() {
        HomePage homePage = page.getInstance(CorpnetLoginPage.class)
                .fillUsername("MANIRA27013")
                .fillPassword("Brac@1234")
                .clickLoginBtn();
        Assert.assertTrue(homePage.hasLogoutLink());

    }
}
