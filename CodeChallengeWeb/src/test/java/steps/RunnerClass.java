package steps;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "steps" }, monochrome = true, plugin = {
		"pretty", "html:target/HtmlReports" }, tags = "@Test")
public class RunnerClass {

}
