package selenium;

import org.apache.log4j.Logger;

public class TC_003 extends BaseTest
{
	private static final Logger log = Logger.getLogger(TC_003.class);

	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("init the properties files.....");
		
		launch("chromebrowser");
		log.info("Opening the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigate gto url : " + childprop.getProperty("amazonurl") );
		
		selectOption("amazondropdown_id","Books");
		log.info("Selected the option Books By using locator : "+ orprop.getProperty("amazondropdown_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		log.info("Entering the text Harry potter By using the locator : " + orprop.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked the element by using locator : " + orprop.getProperty("amazonsearchbutton_xpath"));
		
		
		//WebElement element = driver.findElement(By.id("searchDropdownBox"));
		//element.sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

	}

	
}
