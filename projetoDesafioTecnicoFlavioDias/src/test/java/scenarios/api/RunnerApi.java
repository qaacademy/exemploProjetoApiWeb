package scenarios.api;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/api",monochrome = false, glue = { "scenarios.api" })
public class RunnerApi {

}
