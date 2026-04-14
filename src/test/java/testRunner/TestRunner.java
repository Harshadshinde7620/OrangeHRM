package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features", 
		glue= "stepDefinations",
		tags="@ConfigurationDropdownOptions",
		plugin={
				"pretty",                                    			// Console output
		        "html:target/cucumber-reports-@ConfigurationDropdownOptions.html",  // HTML report
		        "json:target/cucumber.json",                			// JSON report
		        "junit:target/cucumber.xml"     
		        },
		monochrome = true,                               // Clean console output
	    dryRun = false                                   // Check for missing step definitions
	)
		
public class TestRunner extends AbstractTestNGCucumberTests{

	
	
}
