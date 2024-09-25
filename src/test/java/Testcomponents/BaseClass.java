 package Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {


	public WebDriver driver;
	public ChromeOptions co ;
	public Properties prop;

	
	public WebDriver initilizeDriver() throws IOException {
		
		        prop = new Properties();
		        FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//globalData.properties");
		        prop.load(f);

		        String browserName = prop.getProperty("browser");
		        String platformName = prop.getProperty("platform"); // Get platform (OS) from properties file
		        String hubUrl = prop.getProperty("hubUrl"); // Optional - for remote execution (Selenium Grid)
		        String isHeadless = prop.getProperty("headlessMode").trim().toLowerCase();
		        
		        DesiredCapabilities capabilities = new DesiredCapabilities();

		        // Set platform based on OS
		        if (platformName != null && !platformName.isEmpty()) {
		            capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName.toUpperCase());
		        }

		        if (browserName.equalsIgnoreCase("chrome")) {
		            ChromeOptions options = new ChromeOptions();
		            if(isHeadless.equalsIgnoreCase("yes"))
		            {
		            	   options.addArguments("--headless");
		            }
		            options.merge(capabilities);
		            
		            if (hubUrl != null && !hubUrl.isEmpty()) {
		                driver = new RemoteWebDriver(new URL(hubUrl), options); // Use RemoteWebDriver for Grid
		            } else {
		                driver = new ChromeDriver(options); // Local execution
		            }
		        } else if (browserName.equalsIgnoreCase("firefox")) {
		            FirefoxOptions options = new FirefoxOptions();
		            if(isHeadless.equalsIgnoreCase("yes"))
		            {
		            	   options.addArguments("--headless");
		            }
		            options.merge(capabilities);
		            if (hubUrl != null && !hubUrl.isEmpty()) {
		                driver = new RemoteWebDriver(new URL(hubUrl), options); // Use RemoteWebDriver for Grid
		            } else {
		                driver = new FirefoxDriver(options); // Local execution
		            }
		        } else if (browserName.equalsIgnoreCase("edge")) {
		            EdgeOptions options = new EdgeOptions();
		            if(isHeadless.equalsIgnoreCase("yes"))
		            {
		            	   options.addArguments("--headless");
		            }
		            options.merge(capabilities);
		            if (hubUrl != null && !hubUrl.isEmpty()) {
		                driver = new RemoteWebDriver(new URL(hubUrl), options); // Use RemoteWebDriver for Grid
		            } else {
		                driver = new EdgeDriver(options); // Local execution
		            }
		        } else {
		            throw new IllegalArgumentException("Unsupported browser: " + browserName);
		        }

		        // Common driver setup
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		        driver.manage().window().maximize();

		        return driver;
		    }
	
	public WebDriver initilizeMobileDriver() throws IOException {
		
		   prop = new Properties();
	        FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//globalData.properties");
	        prop.load(f);
	        String isHeadless = prop.getProperty("headlessMode").trim().toLowerCase();
	        
		   ChromeOptions options = new ChromeOptions();
		   if(isHeadless.equalsIgnoreCase("yes"))
           {
           	   options.addArguments("--headless");
           }
	        options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "Nexus 5"));
	        WebDriver driver = new ChromeDriver(options);
	        
		return driver;
	
		
		
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver ;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//" + testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ "//reports//" + testCaseName+".png";
	}
	
	public static void waitForPageToLoad(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        for (int i = 0; i < 30; i++) { // Set a timeout limit
            try {
                Thread.sleep(1000); // Wait for 1 second before checking again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (jsExecutor.executeScript("return document.readyState").equals("complete")) {
                break;
            }
        }
	
}
}
