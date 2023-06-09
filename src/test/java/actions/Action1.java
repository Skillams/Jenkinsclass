package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action1 
{

	public static void main(String[] args) 
	{
		ChromeOptions option  = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver(option);
		  driver.manage().window().maximize();
		  driver.get("https://snapdeal.com/");
		  
		  WebElement loc = driver.findElement(By.xpath("//span[contains(text(),'Sign In')]"));
		  Actions a = new Actions(driver);
		  a.moveToElement(loc).perform();
		  driver.findElement(By.linkText("Your Account")).click();
		  
	}

}
