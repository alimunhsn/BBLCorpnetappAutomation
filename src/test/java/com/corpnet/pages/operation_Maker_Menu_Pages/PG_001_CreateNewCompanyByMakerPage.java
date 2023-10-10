package com.corpnet.pages.operation_Maker_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class PG_001_CreateNewCompanyByMakerPage extends BasePage {


    public PG_001_CreateNewCompanyByMakerPage(WebDriver driver) {
        super(driver);
    }


    // public static String ActualTitle  =driver.findElement(By.cssSelector("h1.card-title > label")).getText();
    //String ActualTitle = driver.findElement(By.cssSelector("h1.card-title > label")).getText();


    public PG_001_CreateNewCompanyByMakerPage fillCompanyName(String companyName) {

        //String generatedString = RandomStringUtils.randomNumeric(2);
        //String company = getCompanyName();
        getWebElement(By.id("company_name")).sendKeys(companyName);
        System.out.println("Company Name :- " + companyName);
        return this;
    }

    public PG_001_CreateNewCompanyByMakerPage fillCompanyPhone(String phn) {
        getWebElement(By.id("company_phone")).sendKeys(phn);
        return this;

    }

    public PG_001_CreateNewCompanyByMakerPage fillCompanyCode() {
        // int generatedNumber=Random
        Random random = new Random();
        int randomInt = random.nextInt(9999);
        getWebElement(By.id("company_code")).sendKeys(String.valueOf(randomInt));
        return this;
    }

    public PG_001_CreateNewCompanyByMakerPage fillCompanyEmail(String email) {
        getWebElement(By.id("company_email")).sendKeys(email);
        return this;
    }

    public PG_001_CreateNewCompanyByMakerPage fillAddress(String address) {
        getWebElement(By.id("company_address")).sendKeys(address);
        return this;
    }

    public PG_001_CreateNewCompanyByMakerPage fillCompanyCif(String comCif) {
        getWebElement(By.id("employerCIF")).sendKeys(comCif);
        return this;
    }

    public PG_001_CreateNewCompanyByMakerPage fillContactPerson(String contactPerson) {
        getWebElement(By.id("contactPerson")).sendKeys(contactPerson);
        return this;
    }

    public PG_001_CreateNewCompanyByMakerPage fillContactPhn(String contactPersonPhn) {
        getWebElement(By.id("contactNumber")).sendKeys(contactPersonPhn);
        return this;
    }

    public PG_001_CreateNewCompanyByMakerPage ClickRadioButton() {
        getWebElement(By.cssSelector("label.radio-inline input[value='3']")).click();
        return this;
    }

    public PG_001_CreateNewCompanyByMakerPage FillEmpId() {

        Random random = new Random();
        int EmpId = random.nextInt(7865);
        getWebElement(By.name("employerId")).sendKeys(String.valueOf(EmpId));
        //fillEmpIdEl.sendKeys(String.valueOf(EmpId));
        return this;
    }

    public PG_001_CreateNewCompanyByMakerPage fillRm(String rm) {
        getWebElement(By.id("rm")).sendKeys(rm);
        return this;
    }

    public PG_001_CreateNewCompanyByMakerPage ClickCreateBtn() {
        getWebElement(By.id("createCompanyButton")).click();
        return this;
    }

    public boolean hasNewCompanySuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        //return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
        return getWebElement(By.cssSelector("div.modal-body>p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.NewComCreateComplete);
    }


}
