package com.HRM.TestCases;
import org.testng.annotations.Test;
import com.HRM.POM.AdminPage;
import com.HRM.POM.LoginPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass 

{
	public static WebDriver driver;
	public static LoginPage lp;
    public static AdminPage ad;
    
	@BeforeTest
	
	public void setUpBrowser()
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		lp=new LoginPage(driver);
		ad=new AdminPage(driver);
		
	}

}
