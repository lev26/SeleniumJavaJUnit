package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	private static WebElement object = null;
	
	public static WebElement btn_Login(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//span[@translate = 'trips.checkout.passengers.login']"));
		return object;
	}
	
	public static WebElement txtbx_Email(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//input[@type = 'email']"));
		return object;
	}
	
	public static WebElement txtbx_Password(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//input[@type = 'password']"));
		return object;
	}

	public static WebElement btn_Submit(WebDriver driver) {
		//Login button after email and password have been entered
		
		object = driver.findElement(By.xpath("//button[@type = 'submit']"));
		return object;
	}
}
