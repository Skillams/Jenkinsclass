package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertionDemo 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		String expectedxLink = "Customer Serv";
		
		SoftAssert s = new SoftAssert();
		//s.assertEquals(actualLink, expectedxLink);
		s.assertTrue(actualLink.equals(expectedxLink), "Both links are not equal...");
		
		s.assertTrue(false, "err1");
		
		s.assertTrue(false, "err2");
		
		s.assertTrue(true, "err3");
		
		s.assertTrue(false, "err4");
		
		driver.findElement(By.linkText("Customer Service")).click();
		s.assertAll();
	}

}
