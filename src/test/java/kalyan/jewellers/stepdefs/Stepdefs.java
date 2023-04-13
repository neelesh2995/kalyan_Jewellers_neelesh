package kalyan.jewellers.stepdefs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kalyan.jewellers.core.WebDriverFactory;
import kalyan.jewellers.pageObjects.LandingPageObjects;
import kalyan.jewellers.pageObjects.ProductDiscriptionPageObject;

public class Stepdefs {
	
	public static final Logger logger = LogManager.getLogger(Stepdefs.class);
	
	LandingPageObjects landingPageObjects;
	ProductDiscriptionPageObject productDiscriptionPageObject;
	
	
	WebDriver driver;
	WebDriverWait webDriverWait;
	String base_url = "https://www.candere.com/";
	int implicit_wait = 20;
	Scenario scn;
	
	@Before
	public void setup(Scenario scn) throws Exception  {
		
		    this.scn = scn;
			
		    String browserName = WebDriverFactory.getBrowserName();
			driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		    
			scn.log("Chrome is invoked");
			
			webDriverWait = new WebDriverWait(driver,implicit_wait);
			
			landingPageObjects = new LandingPageObjects(driver,webDriverWait,scn);
			productDiscriptionPageObject = new ProductDiscriptionPageObject(driver,webDriverWait); 
			 
	}
	

	@Given("User navigate to landing page")
	public void user_navigate_to_landing_page() {
		
		landingPageObjects.navigation_url(base_url);
		scn.log("Validate url");
	   	}
	@Given("User User validate the title")
	public void user_user_validate_the_title() {
		   
		   landingPageObjects.landingpageValidation();
		  
		   scn.log("Title validation is done of landing page");
	 	}

	@Given("User search the product {string}")
	public void user_search_the_product(String prodname) throws Exception {
		
		landingPageObjects.searchProduct(prodname);
		
	    scn.log("User send the product name ");
	    
	 	}


	@When("User Validate the product from the suggest name")
	public void user_validate_the_product_from_the_list() {
		
		landingPageObjects.validationProductSearch();
		
		scn.log("the suggest product is clicked and validate");

	}
    

	
	@When("User validate product page title")
	public void user_validate_product_page_title() throws Exception {
	    
		productDiscriptionPageObject.productDisPageValidation();
	    
		scn.log("User validate the product discription page title");

	}

	@Then("Select the size of the product from the drop down {string}")
	public void select_the_size_of_the_product_from_the_drop_down(String size)throws Exception {
		
		productDiscriptionPageObject.productSizeSelect(size);

		scn.log("Size is selected");
    } 

	
	@Given("User scroll down the landing page to About Us section")
	public void user_scroll_down_the_landing_page_to_about_us_section() {
		
		landingPageObjects.scrolldownAboutUs();
		
        scn.log("About Us Element is found");
	}


	
	@When("Under about us category below options are visible")
	public void under_about_us_category_below_options_are_visible(List<String> aboutUsexpectedOptons) {
	    
		landingPageObjects.footerValidation(aboutUsexpectedOptons);

		scn.log("Validation of footer link list is done");
	
		
		
	}

	
	@Given("User scroll down the landing page to Follow Us section")
	public void user_scroll_down_the_landing_page_to_follow_us_section() {
		
		landingPageObjects.scrolldownFollowUs();
	   
        scn.log("Scroll down to Follow Us"); 
	}
	
	
	
	
	
	@When("User validate the below media handles in FollowUs section {string}")
	public void user_validate_the_below_media_handles_in_follow_us_section(String mediahandles) {
	
	landingPageObjects.socialmediaHandles(mediahandles);
	
	scn.log("All media handles validation done");
	
	}
	
	
	@After(order=2)
	public void ScreenShotForFailure(Scenario scn)  {
		if(scn.isFailed())  {
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			byte[] data = screenshot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png","Failed Step Name: " + scn.getName());
			logger.info("Test case is failed screen shot captured");
		}
		else {
			scn.log("Test case is passed no screen shot captured");
		}
	}
		
		
	@After(order=1)
	public void teardown()  {
		
		WebDriverFactory.quitDriver();
		scn.log("Browser is closed");
	}
}
