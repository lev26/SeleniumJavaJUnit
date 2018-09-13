package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtrasPageObjects {

	private static WebElement object = null;
	
	public static WebElement btn_Skip(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//span[@translate = 'trips.seats.modal.skip']"));
		return object;
	}
	
	
	public static WebElement btn_Checkout(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//span[@translate = 'trips.summary.buttons.btn_checkout']"));
		return object;
	}

	
	public static WebElement btn_CheckOutWithoutSeat(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//button[@class = 'popup-msg__button popup-msg__button--cancel']"));
		return object;
	}
	
}
