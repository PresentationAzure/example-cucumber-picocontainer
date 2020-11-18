package example.cucumber.picocontainer.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features"},
        glue = {"example.cucumber.picocontainer"}
)

public class Runner extends AbstractTestNGCucumberTests {

}
