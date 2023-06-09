package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertDemo 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		String expectedxLink = "Customer Serv";
		
		//Assert.assertEquals(actualLink, expectedxLink);
		Assert.assertTrue(actualLink.equals(expectedxLink), "Both links are not equal...");
		
		driver.findElement(By.linkText("Customer Service")).click();
	}
}
