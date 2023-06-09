package pom;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import selenium.BaseTest;

public class POM_001 extends BaseTest
{
  
  
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String btype) throws Exception 
  {
	    init();
		test  = report.createTest("POM_001");
		test.log(Status.INFO, "init the properties files.....");
		
		launch(btype);
		test.log(Status.PASS, "Opening the Browser : " + btype);
		
		navigateUrl("pomurl");
		test.log(Status.FAIL, "Navigate gto url : " + childprop.getProperty("pomurl"));
  }
  
  @Test
  public void f() 
  {
	  page = new LoginPage(driver);
	  page.loginPage();
  }

  @AfterMethod
  public void afterMethod()
  {
	  
  }

}
