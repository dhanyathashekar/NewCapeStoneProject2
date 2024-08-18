package com.HRM.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	//locators
	private By email=By.xpath("//input[@placeholder='Username']");
	private By pwd=By.xpath("//input[@placeholder='Password']");
	private By Login=By.xpath("//button[@type='submit']");
	
	//method
	
	public String doLogin(String em, String ps)
	{
		driver.findElement(email).sendKeys(em);
		driver.findElement(pwd).sendKeys(ps);
		driver.findElement(Login).click();
		return driver.getCurrentUrl();
		
	}
}
