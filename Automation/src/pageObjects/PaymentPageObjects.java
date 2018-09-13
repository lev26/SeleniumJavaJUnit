package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPageObjects {
	
	private static WebElement object = null;

	
	public static WebElement txt_ProfileEmail(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//span[@class = 'username']"));
		return object;
	}
	
	public static WebElement drpdwn_Title(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//select[starts-with(@id, 'title')]"));
		return object;
	}
	
	public static WebElement txtbx_Firstname(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//input[starts-with(@id, 'firstName')]"));
		return object;
	}
	
	
	public static WebElement txtbx_Lastname(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//input[starts-with(@id, 'lastName')]"));
		return object;
	}
	
	public static WebElement drpdwn_PhoneCountry(WebDriver driver) {
		
		object = driver.findElement(By.name("phoneNumberCountry"));
		return object;
	}
	
	public static WebElement txtbx_PhoneNumber(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//input[@name = 'phoneNumber']"));
		return object;
	}
	
	public static WebElement txtbx_CardNumber(WebDriver driver) {
		
		object = driver.findElement(By.name("cardNumber"));
		return object;
	}
	
	public static WebElement drpdwn_CardType(WebDriver driver) {
		
		object = driver.findElement(By.name("cardType"));
		return object;
	}
	
	public static WebElement drpdwn_ExpMonth(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//select[starts-with(@id, 'expiryMonth')]"));
		return object;
	}
	
	public static WebElement drpdwn_ExpYear(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//select[@name = 'expiryYear']"));
		return object;
	}
	
	public static WebElement txtbx_SecurityCode(WebDriver driver) {
		
		object = driver.findElement(By.name("securityCode"));
		return object;
	}
	
	public static WebElement txtbx_CardHolderName(WebDriver driver) {
		
		object = driver.findElement(By.name("cardHolderName"));
		return object;
	}
	
	public static WebElement txtbx_BillingAddressLineOne(WebDriver driver) {
		
		object = driver.findElement(By.name("billingAddressAddressLine1"));
		return object;
	}
	
	public static WebElement txtbx_BillingAddressCity(WebDriver driver) {
		
		object = driver.findElement(By.id("billingAddressCity"));
		return object;
	}
	
	public static WebElement chkbx_AcceptTerms(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//label[starts-with(@for, 'acceptTerms')]"));
		return object;
	}
	
	public static WebElement btn_PayNow(WebDriver driver) {
	
		object = driver.findElement(By.xpath("//button[text() = 'Pay Now']"));
		return object;
	}
	
	public static WebElement txt_PaymentErrorMsg(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//div[@translate = 'common.components.payment_forms.error_explain_declined']"));
		return object;
	}
	
}
