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
	//  "//li//a[@class='klevu-result-box-l2']"
	//   //li//a[@class='klevu-result-box-l2']//div[@class='klevu-img-wrap-l2']//img
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
		
		WebElement searchBoxEle = driver.findElement(SearchBox);
		logger.info("User found the search box");
	    searchBoxEle.sendKeys(prodname);
	    logger.info("User send the product name ");
	    		
	}
	
	public void validationProductSearch()  {
		
		WebElement selectProEle =driver.findElement(productSearchSuggest);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(selectProEle));
		logger.info("Wait is use for find the element");
		Assert.assertTrue(selectProEle.isSelected());
        logger.info("The search result is displayed");
     //   selectProEle.click();
	//	Actions act = new Actions(driver);

	//	logger.info("User use the action class ");
	//	act.click(selectProEle).build().perform();

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", selectProEle);

		logger.info("User click the the suggest product ");
	}
	
	public void scrolldownAboutUs() {
		
		
		WebElement AboutUsEle = driver.findElement(AboutUsSection);
        logger.info("List of AboutUs found");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", AboutUsEle);
		logger.info("Javascript is use for scroll down");

        webDriverWait.until(ExpectedConditions.visibilityOf(AboutUsEle));
        logger.info("Wait is use for find the element");
	    Assert.assertTrue(AboutUsEle.isDisplayed());
	    logger.info("Validate About Us section");
	}
	

	public void footerValidation(List<String> aboutUsexpectedOptons)  {
		
		List<WebElement> aboutUsOpions = driver.findElements(footerList);
	    logger.info("List of AboutUs is found");
		for(int i=0;i < aboutUsexpectedOptons.size(); i++) {
		logger.info("For loop is used");	
		Assert.assertEquals("Validation done ",aboutUsexpectedOptons.get(i), aboutUsOpions.get(i).getText());
		logger.info("Validation of footer link list is done");
		
	    }
	}
		
	public void scrolldownFollowUs()  {
		
		WebElement FollowUsEle = driver.findElement(followUsSection);
        logger.info("FollowUs section found");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",FollowUsEle);
		logger.info("Javascript is use for scroll down");
        webDriverWait.until(ExpectedConditions.visibilityOf(FollowUsEle));
        logger.info("Wait is use for find the element");
        Assert.assertTrue(FollowUsEle.isDisplayed());
	}
	
	public void socialmediaHandles(String mediahandles)  {
		
		if(mediahandles.equalsIgnoreCase("facebook")) {
			WebElement fb= driver.findElement(fbIconEle);
			logger.info("Facebook icon is found");
			webDriverWait.until(ExpectedConditions.elementToBeClickable(fb));
			logger.info("Wait is used until fb icon is clickable");
			fb.click();
			logger.info("fb icon clicked");
			WebElement fbpage = driver.findElement(fbpageHandleEle);
			logger.info("fb handle profile name element found");
			Assert.assertTrue(fbpage.isDisplayed());
			logger.info("Validation of fb handle is done");
		    logger.info(driver.getCurrentUrl());
			scn.log("Validation of fb handle is done");
			System.out.println("title is =  "+driver.getTitle());
			}
			
			if(mediahandles.equalsIgnoreCase("instagram")) {
				
				 WebElement insta = driver.findElement(instaIconEle);
				 logger.info("Instagram icon is found");
				 webDriverWait.until(ExpectedConditions.elementToBeClickable(insta));
				 logger.info("Wait is used until insta icon is clickable");
				 insta.click();
				 logger.info("insta icon is clicked");
		         WebElement instapage = driver.findElement(instapageHandleEle);
		         logger.info("insta handle profile name element is found");
		         Assert.assertTrue(instapage.isDisplayed());
		         logger.info("Validation of insta handle is done");
		         logger.info(driver.getCurrentUrl());
		         scn.log("Validation of insta handle is done");
			}
			
			if(mediahandles.equalsIgnoreCase("twitter"))  {
				
			
				WebElement twitter = driver.findElement(twitterIconEle);
				logger.info("Twitter icon is found");
				webDriverWait.until(ExpectedConditions.elementToBeClickable(twitter));
				logger.info("Wait is used until twitter icon is clickable");
		        twitter.click();
		        logger.info("Twiter icon is clicked");
		        WebElement twitterpage = driver.findElement(twitterpageHandleEle);
		        logger.info("Twitter handle profile name is found");
		        Assert.assertTrue(twitterpage.isDisplayed());
		        logger.info("Validation of twitter handle is done");
		        logger.info(driver.getCurrentUrl());
		        scn.log("Validation of twitter handle is done");


			   }

		
	}

}
