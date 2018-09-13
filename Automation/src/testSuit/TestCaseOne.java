package testSuit;


import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageFunctions.GenericFunctions;
import util.Constant;
import util.ExcelUtils;
import util.Report;


public class TestCaseOne {

    static WebDriver driver;
    private Report logger;
	
	@BeforeClass
	public static void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
	}
	
	
	@Before
	public  void before() {
		//Create an instance of the WebDriver, add implicit wait to it and maximize window
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	
	@After
	public void After() {	
		// Save Report file 
		logger.FinalizeFile();
		driver.quit();
	}
	
	
	@Test
	public void main() throws Exception {
		
		//Removes colon from name
		String dt = LocalDateTime.now().toString().replace(':', ' ');
		
		logger = new Report("c:\\selenium\\"+dt+"_reportTestCaseOne.html");

		//Set File from where we will gather Test Data from
		ExcelUtils.setExcelFile(Constant.Path_TestData,"Sheet1");
			
        //Launch the Ryanair Website
		driver.get("https://www.ryanair.com/ie/en/");
		

		//Different page function calls
		GenericFunctions.funcSelectFlightHomepage(driver);
		GenericFunctions.funcSelectFlightPrices(driver);
		GenericFunctions.funcNavToCheckOut(driver);
		GenericFunctions.funcLogin(driver, logger);
		GenericFunctions.funcPaymentDetailsError(driver, logger);

		//Once this test case is fully run, it will print to the HTML report confirming that
		//Absence of the below text in the HTML is indicative of failure to completely run the test
		logger.reportToHTML("Test case fully run", "");
		
	}
	
}
