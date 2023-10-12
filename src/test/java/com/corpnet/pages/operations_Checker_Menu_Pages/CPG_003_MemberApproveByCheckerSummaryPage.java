package com.corpnet.pages.operations_Checker_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CPG_003_MemberApproveByCheckerSummaryPage extends BasePage {

      public CPG_003_MemberApproveByCheckerSummaryPage(WebDriver driver) {
        super(driver);
    }


    public CPG_003_MemberApproveByCheckerSummaryPage clickSearchBtn() {
        getWebElement(By.name("submit")).click();
        return this;
    }

    public CPG_003_MemberApproveByCheckerSummaryPage clickUnAuthorizeCheckBox() {
        getWebElement(By.id("inlineCheckbox1")).click();
        return this;
    }

    public CPG_003_MemberApproveByCheckerSummaryPage clickDetailsBtn() {
        getWebElement(By.cssSelector("div tbody td a[href*='/company/memberDetails']")).click();
        return this;
    }

    public CPG_003_MemberApproveByCheckerSummaryPage checkAllCompany() {
        getWebElement(By.id("checkAll")).click();
        return this;
    }

    public CPG_003_MemberApproveByCheckerSummaryPage clickSubBtn() {
        getWebElement(By.cssSelector("div button.btn-primary[type='submit']")).click();
        return this;
    }
    public boolean MemberAuthSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        //return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
        return getWebElement(By.cssSelector("div.modal-body>p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.MemberAuthorizeSuccess);
    }
}
