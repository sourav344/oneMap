package demoTests.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Testcomponents.BaseClass;
import demoTests.Pages.OneMapUIPages;

/**
 * 
 */
public class OneMapMobileTest extends BaseClass{

	public WebDriver driver;
	 OneMapUIPages UIpage ;
	
	
	@BeforeTest
	public void LaunchApplication() throws IOException, InterruptedException 
	{
	    driver = initilizeMobileDriver();
	    driver.get(prop.getProperty("URL"));
	    Thread.sleep(15000);
	    UIpage = new OneMapUIPages(driver);
	} 

	@Test(priority=0)  
	public void verifyTitle()
	{
		String title = driver.getTitle();
	    Assert.assertEquals(title, "OneMap");
	    System.out.println("OneMap launched successfully");
	}
	
	
	@Test(priority=1)  
	public void testLogo()
	{
		boolean isLogoDisplayed = UIpage.logo.isDisplayed();
	    Assert.assertEquals(true, isLogoDisplayed);
	    System.out.println("Logo displayed successfully");
	}
	
	@Test(priority = 2)
	public void communityLogo()
	{
		boolean isLogoDisplayed = UIpage.community.isDisplayed();
	    Assert.assertEquals(true, isLogoDisplayed);
	    System.out.println("Community displayed successfully");
	}
	
	@Test(priority = 3)
	public void schoolQueryInfo()
	{
		boolean isLogoDisplayed = UIpage.schoolQueryInfo.isDisplayed();
	    Assert.assertEquals(true, isLogoDisplayed);
	    System.out.println("schoolQueryInfo displayed successfully");
	}
	
	@Test(priority = 4)
	public void medical()
	{
		boolean isLogoDisplayed = UIpage.medical.isDisplayed();
	    Assert.assertEquals(true, isLogoDisplayed);
	    System.out.println("medical displayed successfully");
	}
	
	@Test(priority = 5)
	public void hawkerCentre()
	{
		boolean isLogoDisplayed = UIpage.hawkerCentre.isDisplayed();
	    Assert.assertEquals(true, isLogoDisplayed);
	    System.out.println("hawkerCentre displayed successfully");
	}
	


	
	@AfterTest
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
	

}
