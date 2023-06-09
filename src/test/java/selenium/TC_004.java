package selenium;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;

public class TC_004 extends BaseTest
{
	private static final Logger log = Logger.getLogger(TC_004.class);

	public static void main(String[] args) throws Exception 
	{
		init();
		test  = report.createTest("TC_004");
		test.log(Status.INFO, "init the properties files.....");
		
		launch("chromebrowser");
		test.log(Status.PASS, "Opening the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.FAIL, "Navigate gto url : " + childprop.getProperty("amazonurl"));
		
		selectOption("amazondropdown_id","Books");
		test.log(Status.PASS, "Selected the option Books By using locator : "+ orprop.getProperty("amazondropdown_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		test.log(Status.PASS, "Entering the text Harry potter By using the locator : " + orprop.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.PASS, "Clicked the element by using locator : " + orprop.getProperty("amazonsearchbutton_xpath"));
		
		
		report.flush();

	}

	
}
