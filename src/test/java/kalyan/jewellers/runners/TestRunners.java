package kalyan.jewellers.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "classpath:features",
		glue = "kalyan.jewellers.stepdefs",
		tags = "",
		plugin = {"pretty", // to generate reports
	            "html:target/html/htmlreport.html",
	            "json:target/json/file.json",
	            },		
		monochrome = true,
		publish = true,
		dryRun = false
		)

public class TestRunners {

}
