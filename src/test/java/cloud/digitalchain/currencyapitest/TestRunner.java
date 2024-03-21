package cloud.digitalchain.currencyapitest;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cloud.digitalchain.currencyapitest.steps",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}
