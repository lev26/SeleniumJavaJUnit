package pageFunctions;

import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.ExtrasPageObjects;
import pageObjects.HomepagePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.PaymentPageObjects;
import pageObjects.PriceSelectionPageObjects;
import util.ExcelUtils;
import util.Report;


public class GenericFunctions {
	
	public static void funcSelectFlightHomepage(WebDriver driver) throws Exception {
		//Selects date and destination on home-page 
		
		TimeUnit.SECONDS.sleep(7);
		//Cookies X button
		HomepagePageObjects.btn_CookiesPolicy(driver).click();
		 
		
		//Select One Way Radio button
		HomepagePageObjects.rdn_OneWay(driver).click();
		 
		//Clear preselected selection and enter Dublin
		HomepagePageObjects.txtbx_DepartFrom(driver).clear();
		HomepagePageObjects.txtbx_DepartFrom(driver).sendKeys(ExcelUtils.getCellDataOf("DepartFrom"));
		
		HomepagePageObjects.txtbx_DestinationTo(driver).sendKeys(ExcelUtils.getCellDataOf("DepartTo"));
		HomepagePageObjects.txtbx_DestinationTo(driver).sendKeys(Keys.ENTER);
		
		//Select departure date
		TimeUnit.SECONDS.sleep(2);
		HomepagePageObjects.btn_DepartDate(driver).sendKeys(ExcelUtils.getCellDataOf("DepartDate"));

		
		HomepagePageObjects.chk_AgreeToTerms(driver).click();

		HomepagePageObjects.btn_LetsGo(driver).click();
		TimeUnit.SECONDS.sleep(13);
		
	}


	
	


	
	

public static void funcSelectFlightPrices(WebDriver driver) throws InterruptedException {
	//Selects the Departure flight package
	
	//Switch to the new tab of Selecting Flight prices
	driverSwitchWindow(driver, "childWindow", null);
	
	//Capture all elements with the flight price
	List <WebElement> rows = driver.findElements(By.xpath("//flights-table-price[@on-select-fare = '$ctrl.onSelectFare()']"));
	
	Iterator <WebElement> iter = rows.iterator();
	
	while (iter.hasNext()) {
		//Iterate through the prices in the DOM and click on the displayed one for departure 
		
		WebElement item = iter.next();
		
		boolean bool = item.isDisplayed();

		
		if (bool == true) {
			//Click on available price
			item.click();
			TimeUnit.SECONDS.sleep(5);
			
			//Select flight package
			PriceSelectionPageObjects.btn_StandardFair(driver).click();
			TimeUnit.SECONDS.sleep(4);
			}	
		}
	TimeUnit.SECONDS.sleep(9);
		PriceSelectionPageObjects.btn_Continue(driver).click();
		TimeUnit.SECONDS.sleep(7);
	
	}


public static void driverSwitchWindow(WebDriver driver, String switchIsTo, String ParentWindow){


    String childWindow  = null;

    Set<String> allWindows = driver.getWindowHandles();
    Iterator<String> iterator = allWindows.iterator();

    while(iterator.hasNext()){
        childWindow = iterator.next();
    }


    if(switchIsTo.equals("childWindow")){
        driver.switchTo().window(childWindow);
    }
    else if (switchIsTo.equals("parentWindow")){
        driver.close();
        driver.switchTo().window(ParentWindow);
    }



}



public static void funcNavToCheckOut(WebDriver driver) throws InterruptedException {
	//From Extras page, navigates to checkout after clicking skip on seat preference
	
	
	ExtrasPageObjects.btn_Skip(driver).click();
	TimeUnit.SECONDS.sleep(2);
	ExtrasPageObjects.btn_Checkout(driver).click();
	
	ExtrasPageObjects.btn_CheckOutWithoutSeat(driver).click();
	
	
	
}


public static void funcLogin(WebDriver driver, Report logger) throws Exception {
	//Login into my myRyanair account
	
	//Login page
	LoginPageObjects.btn_Login(driver).click();
	TimeUnit.SECONDS.sleep(1);
	
	
	//Login box
	LoginPageObjects.txtbx_Email(driver).sendKeys(ExcelUtils.getCellDataOf("Email"));
	LoginPageObjects.txtbx_Password(driver).sendKeys(ExcelUtils.getCellDataOf("Password"));
	LoginPageObjects.btn_Submit(driver).click();
	TimeUnit.SECONDS.sleep(3);
	
	
	//Kill the test run if login has failed to open passenger details screen
	if (ExcelUtils.getCellDataOf("AuthenticatedUserLabel").equals(PaymentPageObjects.txt_ProfileEmail(driver).getText())) {
		logger.reportToHTML("Successful login into myRyanAir", "Pass");
	}else {
		logger.reportToHTML("Successful login into myRyanAir", "Fail");
	}
	
	assertEquals("Failure, as the login to myRyanair was not successful", ExcelUtils.getCellDataOf("AuthenticatedUserLabel"), PaymentPageObjects.txt_ProfileEmail(driver).getText());
	
	
}


public static void funcPaymentDetailsError(WebDriver driver, Report logger) throws Exception {
	//Verifies if payment error is present


	
	//Identification 
	PaymentPageObjects.drpdwn_Title(driver).sendKeys(ExcelUtils.getCellDataOf("Title"));
	PaymentPageObjects.txtbx_Firstname(driver).sendKeys(ExcelUtils.getCellDataOf("FirstName"));
	PaymentPageObjects.txtbx_Lastname(driver).sendKeys(ExcelUtils.getCellDataOf("Lastname"));
	
	//country of phone number and phone number
	PaymentPageObjects.drpdwn_PhoneCountry(driver).sendKeys(ExcelUtils.getCellDataOf("CountryOfPhone"));
	PaymentPageObjects.txtbx_PhoneNumber(driver).sendKeys(ExcelUtils.getCellDataOf("PhoneNumber"));
	
	//Credit Card
	PaymentPageObjects.txtbx_CardNumber(driver).sendKeys(ExcelUtils.getCellDataOf("CreditCardNumber"));
	PaymentPageObjects.drpdwn_CardType(driver).sendKeys(ExcelUtils.getCellDataOf("CreditCardType"));
	PaymentPageObjects.drpdwn_ExpMonth(driver).sendKeys(ExcelUtils.getCellDataOf("CreditCardExpMonth"));
	PaymentPageObjects.drpdwn_ExpYear(driver).sendKeys(ExcelUtils.getCellDataOf("CreditCardExpYear"));
	PaymentPageObjects.txtbx_SecurityCode(driver).sendKeys(ExcelUtils.getCellDataOf("CreditCardSecurityCode"));
	PaymentPageObjects.txtbx_CardHolderName(driver).sendKeys(ExcelUtils.getCellDataOf("CreditCardHolderName"));

	//Address
	PaymentPageObjects.txtbx_BillingAddressLineOne(driver).sendKeys(ExcelUtils.getCellDataOf("BillingAddressLineOne"));
	PaymentPageObjects.txtbx_BillingAddressCity(driver).sendKeys(ExcelUtils.getCellDataOf("BillingAddressCity"));
	PaymentPageObjects.chkbx_AcceptTerms(driver).click();

	
	
	PaymentPageObjects.btn_PayNow(driver).click();
	TimeUnit.SECONDS.sleep(7);
	
	String paymentError = PaymentPageObjects.txt_PaymentErrorMsg(driver).getText();
	String expectedPayementError = "As your payment was not authorised we could not complete your reservation. Please ensure that the information was correct or use a new payment to try again";
	
	if (paymentError.equals(expectedPayementError)) {
			logger.reportToHTML("Payment error is presesnt", "Pass");
		}
		else {
			logger.reportToHTML("Payment error is presesnt", "Fail");

		}
	}

}