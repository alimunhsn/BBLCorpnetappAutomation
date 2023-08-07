package com.corpnet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    WebDriver driver;
    WebDriverWait wait;
    public Page(WebDriver driver){
        
    }

}
