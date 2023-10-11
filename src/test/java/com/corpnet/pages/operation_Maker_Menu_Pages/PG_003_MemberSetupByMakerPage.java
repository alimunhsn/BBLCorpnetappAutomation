package com.corpnet.pages.operation_Maker_Menu_Pages;

import com.corpnet.pages.BasePage;
import com.corpnet.util.CorpnetStringMeg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;


public class PG_003_MemberSetupByMakerPage extends BasePage {

        public PG_003_MemberSetupByMakerPage(WebDriver driver) {
        super(driver);
    }


    public PG_003_MemberSetupByMakerPage selectCompany() {
        getWebElement(By.cssSelector("div button[class$='btn dropdown-toggle btn-light bs-placeholder']")).click();
        return this;
    }

    public PG_003_MemberSetupByMakerPage SearchCompany(String company) {

        getWebElement(By.cssSelector("div.dropdown-menu div.bs-searchbox input.form-control[type='search']"))
                .sendKeys(company);
        return this;
    }


    public PG_003_MemberSetupByMakerPage clickCompany() throws InterruptedException {
        Thread.sleep(1000);
        getWebElement(By.cssSelector("div#bs-select-1 ul> li a span.text")).click();
        //driver.findElements(By.cssSelector("div#bs-select-1 ul> li a span.text")).get(index).click();
        getWebElement(By.cssSelector("body")).click();
        return this;
    }


    public PG_003_MemberSetupByMakerPage FillComDivision(String division) {
       getWebElement(By.id("division")).sendKeys(division);
        return this;
    }

    public PG_003_MemberSetupByMakerPage selectMemberGroupB() throws InterruptedException {
        getWebElement(By.cssSelector("div td select option[value='B']")).click();
        return this;
    }

    public PG_003_MemberSetupByMakerPage selectMemberGroupA() throws InterruptedException {
        getWebElement(By.cssSelector("div td select option[value='A']")).click();
        return this;
    }

    public PG_003_MemberSetupByMakerPage fillMemberID() {
        Random random = new Random();
        int randomMemberID = random.nextInt(789678);
        getWebElement(By.id("memberId")).sendKeys(String.valueOf(randomMemberID));
        return this;
    }

    public PG_003_MemberSetupByMakerPage fillAddress(String address) {
        getWebElement(By.id("address")).sendKeys(address);
        return this;
    }

    public PG_003_MemberSetupByMakerPage fillEmail(String email) {
        getWebElement(By.id("email")).sendKeys(email);
        return this;
    }

    public PG_003_MemberSetupByMakerPage fillMemberName(String memberName) throws InterruptedException {
        getWebElement(By.id("memberName")).sendKeys(memberName);
        return this;
    }

    public PG_003_MemberSetupByMakerPage fillDesignation(String designation) {
        getWebElement(By.id("designation")).sendKeys(designation);
        return this;
    }

    public PG_003_MemberSetupByMakerPage fillMob(String mob) {

        getWebElement(By.id("contactNo")).sendKeys(mob);
        return this;
    }

    public PG_003_MemberSetupByMakerPage clickMemberSetupPurpose() throws InterruptedException {
        getWebElement(By.cssSelector("div.form-group label input[value='3']")).click();
        Thread.sleep(2000);
        return this;
    }

    public PG_003_MemberSetupByMakerPage clickCreateBtn() {
        getWebElement(By.cssSelector("div button.btn-primary.btn-primary[type='submit']")).click();
        return this;
    }

    public boolean MemberCreateSuccess() {

        // return getWebElements(By.linkText("Your transaction request has been initiated successfully.")).size() > 0;
        //return getWebElement(By.xpath("(//p[@id='globalAlertBody'])[1]")).getText().trim().contains(CorpnetStringMeg.TranInitiateComplete);
        return getWebElement(By.cssSelector("div.modal-body>p[id='globalAlertBody']")).getText().trim().contains(CorpnetStringMeg.MemberCreateSuccess);
    }

}
