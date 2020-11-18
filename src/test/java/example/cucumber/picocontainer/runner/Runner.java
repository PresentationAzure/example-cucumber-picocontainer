package example.cucumber.picocontainer.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
                plugin = { "pretty" },
                glue = { "example.cucumber.picocontainer" },
                features = { "src/test/resources/features" }
)

public class Runner extends AbstractTestNGCucumberTests {

}
