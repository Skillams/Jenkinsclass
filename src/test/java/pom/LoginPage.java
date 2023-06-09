package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(id="username")public WebElement username;
	@FindBy(id="password")public WebElement password;
	@FindBy(xpath="//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")public WebElement loginButton;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void loginPage()
	{
		username.sendKeys("qatest8776@gmail.com");
		password.sendKeys("password");
		loginButton.click();
	}

}
