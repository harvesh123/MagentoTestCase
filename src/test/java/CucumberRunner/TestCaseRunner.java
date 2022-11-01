package CucumberRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/TestCase.feature",
        glue = {"StepDefinition"},
        tags = "", plugin = {"pretty", "json:target/cucumber-reports/cucumber.json",
        "html:target/cucumber-reports/cucumberreport.html"},
        monochrome = true)

public class TestCaseRunner extends AbstractTestNGCucumberTests {

}
