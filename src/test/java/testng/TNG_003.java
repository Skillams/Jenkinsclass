package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import selenium.BaseTest;

public class TNG_003 extends BaseTest
{
	
  @BeforeMethod(groups = {"regression","sanity"})
  @Parameters("browser")
  public void startProcess(String btype) throws Exception 
  {
	  System.out.println("startProcess");
	    init();
		test  = report.createTest("TNG_003");
		test.log(Status.INFO, "init the properties files.....");
		
		launch(btype);
		test.log(Status.PASS, "Opening the Browser : " + btype);
		
		navigateUrl("amazonurl");
		test.log(Status.FAIL, "Navigate gto url : " + childprop.getProperty("amazonurl"));
  }
  
  @Test(groups = {"regression","sanity"})
  public void amazon() 
  {
	  System.out.println("amazon test");
	    selectOption("amazondropdown_id","Books");
		test.log(Status.PASS, "Selected the option Books By using locator : "+ orprop.getProperty("amazondropdown_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		test.log(Status.PASS, "Entering the text Harry potter By using the locator : " + orprop.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.PASS, "Clicked the element by using locator : " + orprop.getProperty("amazonsearchbutton_xpath"));
  }

  @AfterMethod(groups = {"regression","sanity"})
  public void endProcess() 
  {
	  System.out.println("endProcess");
	  report.flush();
	  driver.quit();
  }
}
