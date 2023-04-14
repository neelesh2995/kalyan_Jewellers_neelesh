package kalyan.jewellers.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import kalyan.jewellers.pageObjects.LandingPageObjects;


public class LandingPageObjects {
		
    private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);
	
    private WebDriver driver;
	private WebDriverWait webDriverWait;
    private Scenario scn;
	
	public LandingPageObjects(WebDriver driver, WebDriverWait webDriverWait, Scenario scn)  {	
		this.driver = driver;
		this.webDriverWait = webDriverWait;
		this.scn = scn;
	}
	
	By SearchBox = By.xpath("//input[@id='search']");
	By productSearchSuggest =By.xpath("//li//a[@class='klevu-result-box-l2']//div[@class='klevu-img-wrap-l2']//img");
	By AboutUsSection = By.xpath("//p[@class='footer_header'][text()='ABOUT US']");
	By footerList = By.xpath("//div[@class='flex_group_item'][1]//a");
	By followUsSection = By.xpath("//p[text()='FOLLOW US']");
	By fbIconEle = By.xpath("//a[@class='social_icons__ fb']");
	By fbpageHandleEle = By.xpath("//h1[text()='Candere by Kalyan Jewellers']");
	By instaIconEle = By.xpath("//a[@class='social_icons__ insta']");
	By instapageHandleEle = By.xpath("//div[@class='x6s0dn4 x78zum5 x1q0g3np xs83m0k xeuugli x1n2onr6']//h2[text()='canderejewellery']");
	By twitterIconEle = By.xpath("//a[@class='social_icons__ twitter']");
	By twitterpageHandleEle = By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-xoduu5 r-18u37iz r-dnmrzs']//span[text()='Candere By Kalyan Jewellers']");
	
	public void navigation_url(String base_url) {
		driver.get(base_url);
		logger.info("User navigate to url");
		Assert.assertEquals(base_url, driver.getCurrentUrl());
		logger.info("Validate url");	
	}
	
	public void landingpageValidation()  {
	    String Expected = "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store";
  	    logger.info("Expected title is "+Expected );
	    String Actual = driver.getTitle();
	    logger.info("Actual title is "+Actual);
        Assert.assertEquals(Expected, Actual);
        logger.info("Validation is done");
	}     
	    
	public void searchProduct(String prodname) throws Exception {
		WebElement searchBoxEle = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SearchBox));
		logger.info("Wait is use to found the search box");
	    searchBoxEle.sendKeys(prodname);
	    logger.info("User send the product name ");
	}
	
	public void validationProductSearch()  {
		WebElement selectProEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(productSearchSuggest));	
		logger.info("Wait is use for find the element of suggest product");
		Assert.assertTrue(selectProEle.isDisplayed());
	    logger.info("The search result is displayed");
	}   
	    
	public void clickSearchProd()  {
		WebElement selectProEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(productSearchSuggest));
		logger.info("Wait is use for find the element");
		selectProEle.click();
		logger.info("User click the the suggest product ");	 
	}    
	      
	public void scrolldownAboutUs() {
		WebElement AboutUsEle = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(AboutUsSection));
        logger.info("Wait is use to found AboutUs section");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", AboutUsEle);
		logger.info("Javascript is use for scroll down");
	    Assert.assertTrue(AboutUsEle.isDisplayed());
	    logger.info("Validation of About Us section");
	}
	

	public void footerValidation(List<String> aboutUsexpectedOptions)  {
		List<WebElement> aboutUsOpions = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerList));
	    logger.info("Wait is use to found the element od List of AboutUs");
		for(int i=0;i < aboutUsexpectedOptions.size(); i++) {
		logger.info("For loop is used");	
		Assert.assertEquals("Validation done ",aboutUsexpectedOptions.get(i), aboutUsOpions.get(i).getText());
		logger.info("Validation of footer link list");
	    }
	}
		
	public void scrolldownFollowUs()  {
		
		WebElement FollowUsEle = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(followUsSection));
        logger.info("Wait is use to find the element of FollowUs section");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",FollowUsEle);
		logger.info("Javascript is use for scroll down");
        Assert.assertTrue(FollowUsEle.isDisplayed());
        logger.info("Validation of FollowUs section");
	}
	
	public void socialmediaHandles(String mediahandles)  {
		
		if(mediahandles.equalsIgnoreCase("facebook")) {
			WebElement fb = webDriverWait.until(ExpectedConditions.elementToBeClickable(fbIconEle));
			logger.info("Wait is use to find the element of Facebook");
			fb.click();
			logger.info("fb icon clicked");
			WebElement fbpage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(fbpageHandleEle));
			logger.info("Wait is use to find the element of fb handle profile name");
			Assert.assertTrue(fbpage.isDisplayed());
			logger.info("Validation of fb profile name");
		    logger.info(driver.getCurrentUrl());
			scn.log("Validation of fb handle is done");
			}
			
		if(mediahandles.equalsIgnoreCase("instagram")) {
		    WebElement insta = webDriverWait.until(ExpectedConditions.elementToBeClickable(instaIconEle));
			logger.info("Wait is use to find the element of Instagram icon");
			insta.click();
			logger.info("Insta icon is clicked");
		    WebElement instapage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(instapageHandleEle));
		    logger.info("Wait is use to find the element of insta handle profile name");
		    Assert.assertTrue(instapage.isDisplayed());
		    logger.info("Validation of insta profile name");
		    logger.info(driver.getCurrentUrl());
		    scn.log("Validation of insta handle is done");
			}
			
		if(mediahandles.equalsIgnoreCase("twitter"))  {	
			WebElement twitter = webDriverWait.until(ExpectedConditions.elementToBeClickable(twitterIconEle));
			logger.info("Wait is used to find the element of Twitter icon");
		    twitter.click();
	        logger.info("Twiter icon is clicked");
		    WebElement twitterpage = webDriverWait.until(ExpectedConditions.elementToBeClickable(twitterpageHandleEle));
	        logger.info("Wait is used to find the element of Twitter handle profile name");
	        Assert.assertTrue(twitterpage.isDisplayed());
	        logger.info("Validation of twitter profile name");
	        logger.info(driver.getCurrentUrl());
	        scn.log("Validation of twitter handle is done");
			}
	}

}
