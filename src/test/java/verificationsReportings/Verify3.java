package verificationsReportings;

import com.aventstack.extentreports.Status;

import selenium.BaseTest;

public class Verify3 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test  = report.createTest("Verify3");
		test.log(Status.INFO, "init the properties files.....");
		
		launch("chromebrowser");
		test.log(Status.PASS, "Opening the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.PASS, "Navigate gto url : " + childprop.getProperty("amazonurl"));
		
		String expectedLink = "Customer Serv";
		
		if(!isLinkEqual(expectedLink))
			reportFailure("Both links are not equal...");
		else
			reportPass("Both links are equal...");
				
		report.flush();
		
	}
}
