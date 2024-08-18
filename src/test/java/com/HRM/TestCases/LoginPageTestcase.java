package com.HRM.TestCases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginPageTestcase extends BaseClass

{
  @Test(priority =1)
  public void validateLogin() 
  {
	 String Pageurl= lp.doLogin("Admin","admin123");
	  //Assert.assertTrue(Pageurl.contains("Login"),"test Fail: Test fail");
	  System.out.println("Test pass: Login completed");
  }
  
  @Test(priority =2)
  public void AdminTest() 
  
  {
	  ad.getOptions();
	  String expUrl="https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, expUrl);
		System.out.println();
		System.out.println("Admin page opened successfully");
  }
  
  @Test(priority =3)
  
  public void AdminTest1()
  {
	  ad.searchUserName("admin");
	  
  }
  @Test(priority =4)
  
  public void AdminTest2() throws InterruptedException
  {
	  ad.searchByUserRole();
  }
  
  @Test(priority =5)
  public void AdminTest3() 
  {
	  ad.searchByUserStatus();
  }
  

  }
  
  

