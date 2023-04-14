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
		
    By productsize = By.xpath("//div//select[@id='mt_size']");
	By priceUpdatePopup = By.xpath("//div//span[@class='snackbar--icon']");
        
	public void productDisPageValidation()  throws Exception  {	
	    Thread.sleep(4000);
		logger.info("Product discription page is open");
    	String ExpectedTitle = "Majestic Solitaire Diamond Ring";
	    logger.info("Expected search product discription page title");    
		String ActualTitle = driver.getTitle();
		logger.info("Actual product discription page title ");
	   	Assert.assertEquals("Validate the product discription page", ExpectedTitle, ActualTitle);
		logger.info("User validate the product discription page title");	
	}
	
	public void productSizeSelect(String size) {
		WebElement selectProSizeEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(productsize));
	    logger.info("Wait is use to find the element product size dropdown");
		Select sct = new Select(selectProSizeEle);
		logger.info("Select class is created ");
		sct.selectByVisibleText(size);
        logger.info("Size is selected");
        WebElement pricepopEle = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(priceUpdatePopup));
        logger.info("wait is use to find the element of price update popup");
        Assert.assertTrue(pricepopEle.isDisplayed());
        logger.info("Validation of price update pop is done");
	}
}
