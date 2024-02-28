package Step_Definitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
 
public class Hooks {
	public WebDriver driver;
	
	@Before
	public void setup(String br) throws IOException, InterruptedException
	{
		
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver();
				break;
		case "edge": driver = new EdgeDriver(); 
				break;
		default: 
				System.out.println("No matching browser");
				return;
		}


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@After
	public void closure()
	{ 
		driver.close();
	}
	
	@AfterStep
     public void addScreenshot(Scenario scenario) {
        
    	// this is for cucumber junit report
       
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        
      
    }
	
 
}