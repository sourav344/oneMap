package demoTests.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class OneMapUITest extends BaseClass{

	public WebDriver driver;
	  OneMapUIPages UIpage ;
	
	
	@BeforeTest
	public void LaunchApplication() throws IOException, InterruptedException 
	{
	    driver = initilizeDriver();
	    driver.get(prop.getProperty("URL"));
	    waitForPageToLoad(driver);
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
	
	
	
	
	@Test(priority=6) 
	public void testLogo_negative()
	{
		boolean isLogoDisplayed = UIpage.false_logo.isDisplayed();
	    Assert.assertEquals(true, isLogoDisplayed);
	    System.out.println("Logo not displayed");
	}

	@Test(priority=7)  // Run second
	public void searchBar() throws InterruptedException
	{
	    UIpage.SearchBar.sendKeys(prop.getProperty("SearchAddress"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].blur();", UIpage.SearchBar);
	    Thread.sleep(4000);
	    driver.findElement(By.xpath(UIpage.searchResult_xpath+prop.getProperty("SearchAddress")+"']")).click();
	}

	@Test(priority=8)  // Run third
	public void verifySearch() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement markerInfoBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UIpage.markerInfoBox_xpath+prop.getProperty("SearchAddress")+"']")));
		Assert.assertEquals(markerInfoBox.isDisplayed(), true);
	}

	@Test(priority=9)  // Run last
	public void navigateHere()
	{
	    
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", UIpage.navigateHere);
	}
	
	@Test(priority=10) 
	public void originsearch() throws InterruptedException
	{
		Thread.sleep(5000);
		UIpage.originInput.sendKeys(prop.getProperty("originAddress"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].blur();", UIpage.originInput);
		    Thread.sleep(4000);
		    driver.findElement(By.xpath(UIpage.searchResult_xpath+prop.getProperty("originAddress")+"']")).click();
	}
	
	@Test(priority=11) 
	
	public void threeDimensionView() throws InterruptedException
	{
		Thread.sleep(5000);
		UIpage.threeDim.click();
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
