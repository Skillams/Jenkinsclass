package selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//webdriver.gecko.driver
		//WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver1 = new FirefoxDriver(); 
		
		//webdriver.ie.driver
		//WebDriverManager.iedriver().setup();
		InternetExplorerDriver driver2 = new InternetExplorerDriver();
		
		//webdriver.edge.driver
		//WebDriverManager.edgedriver().setup();
		EdgeDriver driver3 = new EdgeDriver();
		
		
		
		
	}

}
