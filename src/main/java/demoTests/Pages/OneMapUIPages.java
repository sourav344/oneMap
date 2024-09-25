package demoTests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Functions.Uitlities.Utility;

public class OneMapUIPages extends Utility {

	WebDriver driver;
	
	public OneMapUIPages(WebDriver driver)
	
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//img[@alt='OneMap3']")
	public WebElement logo;
	
	@FindBy(xpath="//img[@alt='OneMap_flase_logo']")
	public WebElement false_logo;
	
	@FindBy(xpath="//div[@id='Community']")
	public WebElement community;
	
	@FindBy(xpath="//div[@id='SchoolQueryInfo']")
	public WebElement schoolQueryInfo;
	
	@FindBy(xpath="//div[@id='Medical']")
	public WebElement medical;
	
	@FindBy(xpath="//div[@id='HawkerCentres']")
	public WebElement hawkerCentre;
	
	
	@FindBy(xpath="//input[@id='search_property']")
	public WebElement SearchBar;
	
	public String searchResult_xpath = "//li//span[@id='searchresult_name'][text()='";
	
	public String markerInfoBox_xpath = "//div[@id='markerInfobox']//span[text()='";
	
	@FindBy(xpath="//span[text()='Navigate Here']")
	public WebElement navigateHere;
	
    @FindBy(xpath="//input[@id='originInput']")
    public WebElement originInput;
    
    @FindBy(xpath="//div[@id='btn2D3D']")
    public WebElement threeDim;
    
	
	
	
}
