package kalyan.jewellers.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductDiscriptionPageObject {

	
private static final Logger logger = LogManager.getLogger(ProductDiscriptionPageObject.class);
	
	private WebDriver driver;
	
	private WebDriverWait webDriverWait;
	
	
	public ProductDiscriptionPageObject(WebDriver driver, WebDriverWait webDriverWait)  {
		
		this.driver = driver;
		this.webDriverWait = webDriverWait;

	}
	
	
    By productsize = By.id("//div//select[@id='mt_size']");
    By prodnameValiEle = By.id("//h1[@class='page-title']//span[text()='Majestic Solitaire Diamond Ring']");
	
	
	
	public void productDisPageValidation()  throws Exception  {
		
		WebElement prodnamedisp = driver.findElement(prodnameValiEle);
		webDriverWait.until(ExpectedConditions.visibilityOf(prodnamedisp));
		Assert.assertTrue(prodnamedisp.isDisplayed()); 
//		logger.info("Product discription page is open");
//    	String ExpectedTitle = "Majestic Solitaire Diamond Ring";
//		logger.info("Expected search product discription page title");    
//		String ActualTitle = driver.getTitle();
//		logger.info("Actual product discription page title ");
//		Assert.assertEquals("Validate the product discription page", ExpectedTitle, ActualTitle);
//		logger.info("User validate the product discription page title");
	
		
	
	}
	
	public void productSizeSelect(String size) throws Exception{
		
		WebElement selectProSizeEle = driver.findElement(productsize);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(selectProSizeEle));
		logger.info("The product size dropdown element is found"); 
        logger.info("Wait is use for find the element");

		Select sct = new Select(selectProSizeEle);
		logger.info("Select class is created ");
		sct.selectByVisibleText(size);
        logger.info("Size is selected");

	}
	



}
