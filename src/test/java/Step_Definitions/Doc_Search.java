package Step_Definitions;

import UtilityFile.excel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import UtilityFile.excel;
import pageObjects.Corporate;
import pageObjects.FilterDoctor;
import pageObjects.FindingDoctors;
import pageObjects.GetDocName;
import pageObjects.Surgeries;


public class Doc_Search {
	
	
	public static WebDriver driver=new ChromeDriver();
	
	@Given("Opening the browser")
	public void opening_the_browser() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		
		
		
	}

	@When("Provide Location and Specialization of the Doctor")
	public void provide_location_and_specialization_of_the_doctor() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		FindingDoctors searchH = new FindingDoctors(driver);
		String[] data = excel.FileData();
		searchH.location_Nav();
		searchH.Location_Value(data[0], driver);
		
		searchH.Search_Nav();
		searchH.Search_Value(data[1],driver);
		
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\locNdSp.png");
		FileHandler.copy(FirstScr, destination);
		
		//path=Scrshot.SShot("LocNdSpe", driver);
	}

	@When("Filter by Experience, Patient Stories")
	public void filter_by_experience_patient_stories() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
        
		FilterDoctor sortDoc = new FilterDoctor(driver);
		
		sortDoc.PStories_Nav();
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\Pstories.png");
		FileHandler.copy(FirstScr, destination);
		
		//path=Scrshot.SShot("Pstories", driver);
		
		sortDoc.PStories();
		
		sortDoc.Experience_Nav();
		File FirstScr1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination1 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\exp.png");
		FileHandler.copy(FirstScr1, destination1);
		
		//path=Scrshot.SShot("experience", driver);
		
		sortDoc.Experience_val();
		
		sortDoc.AllFilters_Nav();
		
		File FirstScr2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination2 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\allfilters.png");
		FileHandler.copy(FirstScr2, destination2);
		
		
		//path=Scrshot.SShot("allfilters", driver);
		
		sortDoc.Availability_Nav();
		
		sortDoc.Sort_Nav();
		File FirstScr3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination3 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\sort.png");
		FileHandler.copy(FirstScr3, destination3);
		
		//path=Scrshot.SShot("sort", driver);
		
		sortDoc.Sort();
	}

	@When("Retrive first five Doctors")
	public void retrive_first_doctors() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
        GetDocName GetDoc = new GetDocName(driver);
		
		GetDoc.Doctor_Nav();
        
		GetDoc.Hospital_Nav();
		
		GetDoc.Write_Data_Excel();

	}

	@When("Retrive the list of surgeries")
	public void retrive_the_list_of_surgeries() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		Surgeries surg = new Surgeries(driver);
		surg.Surgery_Nav();
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\surg.png");
		FileHandler.copy(FirstScr, destination);
		
		//path=Scrshot.SShot("surgeryTab", driver);
		
		Thread.sleep(3000);
		
		surg.SurgeryList();
		
		Thread.sleep(3000);
		
		surg.Write_Data_Excel();
	}

	@When("Validate form by valid and invalid data")
	public void validate_form_by_valid_and_invalid_data() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		Corporate form = new Corporate(driver);
		form.Corporate_Nav();
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\form.png");
		FileHandler.copy(FirstScr, destination);
		
		//path=Scrshot.SShot("form", driver);
		
		form.Form_Val("2304113@.com");
		form.Submit();
		File FirstScr2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination2 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\invalid.png");
		FileHandler.copy(FirstScr2, destination2);
		
		//path=Scrshot.SShot("Inavlid", driver);
		
		form.Form_Val("2304113@cognizant.com");
		form.Submit();
		File FirstScr3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination3 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\valid.png");
		FileHandler.copy(FirstScr3, destination3);
		
		//path=Scrshot.SShot(" valid", driver);
	}

	@When("close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}


}
