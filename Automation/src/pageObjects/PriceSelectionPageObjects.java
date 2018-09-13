package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriceSelectionPageObjects {
	
	private static WebElement object =null;

	
	public static WebElement btn_StandardFair(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//span[@translate = 'trips.flight_list_table.table_heading.regular-fare']"));
		return object;
	}
	
	
	public static WebElement btn_Continue(WebDriver driver) {
		
		object = driver.findElement(By.xpath("//button[@id = 'continue']"));
		return object;
	}
	
}
