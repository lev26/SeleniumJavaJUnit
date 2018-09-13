package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomepagePageObjects {
	
	private static WebElement object = null;
	
	public static WebElement txtbx_DepartFrom(WebDriver driver) {
	
		object = driver.findElement(By.xpath("//input[@aria-labelledby = 'label-airport-selector-from']"));
		return object;
		
	}
	
	public static WebElement txtbx_DestinationTo(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//input[@aria-labelledby = 'label-airport-selector-to']"));
		return object;
		
	}
	

	
	public static WebElement btn_CookiesPolicy(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//div[@data-ref = 'cookies-policy-icon']"));
		return object;
	}

	
	public static WebElement btn_DepartDate(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//input[@aria-label = 'Fly out: - DD']"));
		return object;
	}
	
	
	public static WebElement btn_ReturnDate(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//input[@aria-label = 'Fly back: - DD']"));
		return object;
	}
	
	
	public static WebElement rdn_OneWay(WebDriver driver) {
		
		object = driver.findElement(By.id("flight-search-type-option-one-way"));
		return object;
	}
	
	public static WebElement chk_AgreeToTerms(WebDriver driver) {
		
		object = driver.findElement(By.className("terms-conditions-checkbox-span"));
		return object;
		
	}
	
	public static WebElement btn_LetsGo(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//button[@ng-click = 'searchFlights()']"));
		return object;
	}
}
