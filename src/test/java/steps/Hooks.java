package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import wdMethods.SeMethods;

public class Hooks extends SeMethods{
	@Before
	public void beforeScenario(Scenario sc) {
		startResult();
		startTestModule(sc.getName(), sc.getId());
		test = startTestCase(sc.getName());
		test.assignCategory("smoke");
		test.assignAuthor("koushik");
		startApp("chrome", "http://leaftaps.com/opentaps");
	}
	@After
	public void afterScenario(Scenario sc) {
		closeAllBrowsers();
		endResult();
	}
}







