package kalyan.jewellers.core;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverFactory {

	
	  private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
	
      private static WebDriver driver = null;
	
	
	  public static WebDriver getWebDriverForBrowser (String browser) throws Exception{
		
		  switch (browser.toLowerCase()) {
		  case "chrome":
			  WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
			  logger.info("Browser is invoked");
			  break;	
		
	      case "firefox":
		      WebDriverManager.firefoxdriver().setup();
		      driver = new FirefoxDriver();
		      logger.info("Browser is invoked");
		      break;
	      
	      default:
			  logger.fatal("No such browser is implemented.Browser name sent"+browser);
			  throw new Exception("No such browser is implemented.Browser name sent"+browser);
		   }
		  
		  
		   driver.manage().window().maximize();
		   logger.info("Window is maximize");
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		   return driver;
	     }
	
	      public static void quitDriver() {
		
		       driver.quit();
		       logger.info("Browser is closed");
	      }
	
          public static String getBrowserName()  {
		
        	  String browserDefault = "chrome";
              String browserSentFromCmd = System.getProperty("browser");
              
              if (browserSentFromCmd==null)  {
            	  return browserDefault;
              }
              else {
            	  return browserSentFromCmd;
              }

	      }
}
