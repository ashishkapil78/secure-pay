package securepay;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "usage:target/cucumber-usage.json"},
        glue = "securepay.scenarios",
        features = {"classpath:features/"}
)
public class Cukes extends AbstractTestNGCucumberTests {
}
