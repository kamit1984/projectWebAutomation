package com.kraken.features;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Create by Amit on 11/23/20
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features =
                {
                "src/test/java/com/kraken/features/responseCode.feature",
                "src/test/java/com/kraken/features/consoleErrors.feature",
                "src/test/java/com/kraken/features/links.feature"
                },
        glue = "com.kraken.stepDefns",
//        publish = true,
        tags = "@Smoke",
        dryRun = false,
        plugin = "html:target/cucumber-report.html"
)
public class Runner {

}
