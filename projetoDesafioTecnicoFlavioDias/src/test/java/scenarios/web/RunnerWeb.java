package scenarios.web;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/web",monochrome = false, glue = { "scenarios.web" })
public class RunnerWeb {

}
