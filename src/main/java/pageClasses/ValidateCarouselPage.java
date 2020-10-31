package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidateCarouselPage {

	public WebDriver driver;
	
//	By carouselitems=By.xpath("//div[@class='owl-item active']//h3/a");
	By carouselitems=By.cssSelector("div.owl-item.active h3 a");
	
	
	
	public ValidateCarouselPage(WebDriver driver) {
		
		this.driver=driver;
		
		
	}
	
	public List<WebElement> carouselitemsList() {
		
		return driver.findElements(carouselitems);
		
	}
	
}
