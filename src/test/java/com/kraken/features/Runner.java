package com.kraken.features;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Create by Amit on 11/23/20
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/kraken/features/responseCode.feature",

        glue = "com.kraken.stepDefns",
//        format = {"pretty", "html:target/cucumber-html-report", "json-pretty:target/cucumber-report.json"},
        // format seems to be deprecated
//        publish = true,
        tags = "@Smoke",
        dryRun = false,
        plugin = "html:target/cucumber-report.html"
)
public class Runner {


}
