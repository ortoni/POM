package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",
				glue= {"pages", "steps"}, 
				monochrome=true,
				plugin = { "pretty","html:CucumberReports"},
				dryRun = false,
				snippets = SnippetType.CAMELCASE
				)
public class TestRunner {

}








