package TestRunner;



import org.junit.runner.RunWith; 
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Feature_files//DocSearch.feature", glue = "Step_Definitions")
public class testRunner {
	// Your test runner class implementation
	}
