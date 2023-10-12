package com.corpnet.pages.operation_Maker_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PG_002CreateComAccountManaByMakerPage extends BasePage {


       public PG_002CreateComAccountManaByMakerPage(WebDriver driver) {
        super(driver);
    }


    public PG_002CreateComAccountManaByMakerPage searchCompany(String company) {
        getWebElement(By.cssSelector("div[id='dataTables-example_filter'] label input[type='search']")).sendKeys(company);
        return this;
    }

    public PG_002CreateComAccountManaByMakerPage clickRadioBtn() {
        getWebElement(By.id("inlineCheckbox1")).click();
        return this;
    }

    public PG_002CreateComAccountManaByMakerPage ClickCompanyAccountBtn() {
        getWebElement(By.cssSelector("div tbody td a[href*='/company/company_account/']")).click();
        return this;
    }

    public PG_002CreateComAccountManaByMakerPage clickCheckBoxCompanyAccount() {
        getWebElement(By.cssSelector("div tbody tr td input[name*='id'][value='1501101613623002']")).click();
        getWebElement(By.cssSelector("div tbody tr td input[name*='id'][value='1501201806446003']")).click();
        getWebElement(By.cssSelector("div tbody tr td input[name*='id'][value='1501201806446005']")).click();
        getWebElement(By.cssSelector("div tbody tr td input[name*='id'][value='1503101687517001']")).click();
        getWebElement(By.cssSelector("div tbody tr td input[name*='id'][value='1539203428897001']")).click();
        getWebElement(By.cssSelector("div tbody tr td input[name*='id'][value='1501101613623001']")).click();
        getWebElement(By.cssSelector("div tbody tr td input[name*='id'][value='2018064460016']")).click();
        return this;
    }

    public PG_002CreateComAccountManaByMakerPage selectTCSAAcc() {
        getWebElement(By.cssSelector("div tbody tr td select[name*='trustCumAccount']>option[value$='6446005AC1']")).click();
        return this;
    }

    public PG_002CreateComAccountManaByMakerPage clickSubmitBtn() {
        getWebElement(By.name("submit")).click();
        return this;
    }
    public boolean hasNewCompanyAccountSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        //return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
        return getWebElement(By.cssSelector("div.modal-body>p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.NewCompanyAccountUpdate);
    }

}
