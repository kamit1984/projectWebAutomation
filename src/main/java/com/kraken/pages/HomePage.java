package com.kraken.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Create by Amit on 21/11/20
 */
public class HomePage extends BasePage {

    private String testURL = "https://www.kraken.com/";

    public HomePage(String browserName) {
        super(browserName);
        driver.get(testURL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Get Started']"))).isDisplayed();
    }

    public void SignIn(){

    }

    public void CreateAccount(){

    }
//    public void performLogout(){
//        driver.findElement(By.cssSelector("button[data-testing-uid='userMenu-avatar-button']")).click();
//        driver.findElement(By.cssSelector("button[data-testing-uid='userMenu-logout-button']")).click();
//
//        // Verify Logged out is successful.
//        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Sign in to your team')]"))).isDisplayed());
//    }
//
//    public void goToCelonisHome(){
//        driver.findElement(By.cssSelector("a[data-testing-uid=\"backToProject-logo-AnalysisMenu\"]")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.ce-header__title")));
//    }
}
