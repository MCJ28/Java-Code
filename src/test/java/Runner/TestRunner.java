package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"html:CucumberReport/manu.html"},
		features = "src/test/java/Features",
		glue = "StepDefinition",
		tags = "@Dev"
		)
public class TestRunner extends AbstractTestNGCucumberTests
{
	
}
