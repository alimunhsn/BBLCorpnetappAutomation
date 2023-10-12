package com.corpnet.pages.operations_Checker_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CPG_002_ApproveComAccountByCheckerPage extends BasePage {

        public CPG_002_ApproveComAccountByCheckerPage(WebDriver driver) {
        super(driver);
    }


    public CPG_002_ApproveComAccountByCheckerPage clickCheckBoxForWaitingApprove() {
        getWebElement(By.id("inlineCheckbox3")).click();
        return this;
    }

    public CPG_002_ApproveComAccountByCheckerPage searchCompany(String companySearch) {
        getWebElement(By.cssSelector("div input.form-control-sm")).sendKeys(companySearch);
        return this;
    }

    public CPG_002_ApproveComAccountByCheckerPage clickDetailBtnAndCheckBoxForAll() {
        getWebElement(By.cssSelector("div tbody td a[href*='/company/com-details']")).click();
        getWebElement(By.name("select_all")).click();
        return this;
    }

    public CPG_002_ApproveComAccountByCheckerPage clickApproveBtn() {

        getWebElement(By.name("submit")).click();
        return this;
    }

    public boolean hasNewCompanyApproveSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        //return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
        return getWebElement(By.cssSelector("div.modal-body>p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.NewComAuthorizeComplete);
    }

}
