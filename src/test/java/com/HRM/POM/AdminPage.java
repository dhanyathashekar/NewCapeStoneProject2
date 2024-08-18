package com.HRM.POM;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminPage 
{
private WebDriver driver;
private WebDriverWait wait;

	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	//locators
		private By admin=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]");
		private By leftNav_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li");
 
	//methods
	public void getOptions()
	  {

		 WebElement leftOptions = driver.findElement(leftNav_loc);
	        wait.until(ExpectedConditions.visibilityOf(leftOptions));
			java.util.List<WebElement> optionsList = driver.findElements(leftNav_loc);
			for(WebElement option: optionsList)
			{
				System.out.println(option.getText());
			}
			System.out.println();
			
			WebElement adminlink=driver.findElement(admin);
			adminlink.click();
		}
	

	
	//locators
	private By searchBox_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
	private By searchButton_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
	private By username_result=By.xpath("//div[@class='oxd-table-card']/div/div[2]/div");
	private By userRole_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]");
	
	//Methods
	public void searchUserName(String username)
	{
		driver.findElement(searchBox_loc).sendKeys(username);
		driver.findElement(searchButton_loc).click();
		System.out.println("List of Username found:");
		java.util.List<WebElement> result=driver.findElements(roleResult_loc);
		for(WebElement li:result)
		{
			System.out.println(" Record: "+li.getText());
		
		}
		System.out.println();
		System.out.println("Search records found: "+driver.findElement(username_result).getText());
		driver.navigate().refresh();
	}
	
	//locators
	private By adminRoleOption_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/span");
	private By roleResult_loc=By.xpath("//div[@class='oxd-table-card']/div/div[2]/div");
	
	//Methods
	
	public void searchByUserRole() throws InterruptedException
	{
		driver.findElement(userRole_loc).click();
		driver.findElement(adminRoleOption_loc).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).getText();
		driver.findElement(searchButton_loc).click();
		java.util.List<WebElement> result=driver.findElements(roleResult_loc);		
		int count=0;
		System.out.println("List of Username found:");
		for(WebElement li:result)
		{
			count++;
			System.out.println(count+" record: "+li.getText());	
		}
		System.out.println();
		System.out.println("Total Record found: "+count);
		driver.navigate().refresh();
	}
	
	//locators
	
		private By status_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]");
		private By statusresult_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div");

	//Methods
	public void searchByUserStatus()
	{
		driver.findElement(status_loc).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]/span")).click();
		
		java.util.List<WebElement> result=driver.findElements(statusresult_loc);
		int count=0;
		System.out.println("Result by userStaus: ");
		for(WebElement li: result)
		{
			count++;
			System.out.println(count+ " record:"+li.getText());
		}
		System.out.println();
		System.out.println("Total Record found: "+count);
	}	
	
}