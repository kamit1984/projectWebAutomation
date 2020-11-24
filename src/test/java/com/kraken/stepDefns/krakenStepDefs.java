package com.kraken.stepDefns;

import com.kraken.pages.HomePage;
import com.kraken.utilities.HttpResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create by Amit on 11/23/20
 */
public class krakenStepDefs {
    private static Logger log = Logger.getLogger(krakenStepDefs.class.getName());
    private HomePage homePage;

    @AfterClass
    public void clearDown(){
        homePage.driver.quit();

    }
    @Given("we are going to test scenarios in Browser {string}")
    public void we_are_going_to_test_scenarios_in_browser(String string) {
        // Write code here that turns the phrase above into concrete actions
        log.info("Executing Background block");
        homePage = new HomePage(string.toLowerCase());
    }

//    @Given("user navigates to the URL {String} in browser")
//    public void user_navigates_to_the_url_in_browser(String St) {
//        // Write code here that turns the phrase above into concrete actions
//        log.info("Executing @Given block");
//    }

    @Given("user navigates to the URL {string} in browser")
    public void user_navigates_to_the_url_in_browser(String string) {
        // Write code here that turns the phrase above into concrete actions
        log.info("Executing @Given block");
        log.info("String = " + string);
        homePage.driver.get(string);
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace();}
    }

    @Then("verify that no console errors are detected on the page.")
    public void verify_that_no_console_errors_are_detected_on_the_page() {
        // Write code here that turns the phrase above into concrete actions
        log.info("Executing @Then block");
        Logs logs = homePage.driver.manage().logs();
        LogEntries entries = logs.get(LogType.BROWSER);
        List<LogEntry> errorLogs = entries.filter(Level.SEVERE);

        if (errorLogs.size() != 0) {
            for (LogEntry logEntry: errorLogs) {
                log.log(Level.SEVERE,"Found error in logs: " + logEntry.getMessage());
            }
            log.log(Level.SEVERE, errorLogs.size() + " Console error found");
            Assert.assertTrue(false);
        }else{
            log.info("No console erros found.");
        }
    }

    @Then("verify that there are no broken links on the page.")
    public void verify_that_there_are_no_broken_links_on_the_page() {
        //Get all the links on the page
        List<WebElement> links = homePage.driver.findElements(By.cssSelector("a"));

        boolean flag = true;
        String href;
        int statusCode;
        List<String> urls = new ArrayList<>();

        for(WebElement link : links) {
            href = link.getAttribute("href");
            log.info("Href = " + href);
                statusCode = new HttpResponseCode().httpResponseCodeViaGet(href);
                if(404 == statusCode) {
//                    log.log(Level.SEVERE, href + " gave a response code of " + statusCode);
                    urls.add(href);
                    flag = false;
                }
        }
        log.info("Below urls gave 404 error ..... ");
        for (String url: urls) {
            log.info(url);
        }

        Assert.assertTrue(flag);
    }

//    @Then("verify that expected response code {string} is received.")
//    public void verifyThatExpectedResponseCodeIsReceived(String arg0) {
//        String expectedResponseCode = arg0;
//        String actualResponseCode = new HttpResponseCode().httpResponseCodeViaGet(href);
//    }

    @Then("verify that expected response code {string} is received when we navigate to url {string}.")
    public void verifyThatExpectedResponseCodeIsReceivedWhenWeNavigateToUrl(String arg0, String arg1) {
        int expectedResponseCode = Integer.parseInt(arg0);
        int actualResponseCode = new HttpResponseCode().httpResponseCodeViaGet(arg1);
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
}
