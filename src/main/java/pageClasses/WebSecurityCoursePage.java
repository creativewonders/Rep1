package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebSecurityCoursePage {

	public WebDriver driver;
	
	By websecuritycourse=By.xpath("//div[@class='course-block block description_with_share_icons  even-stripe']//p[2]");
	
	
	public WebSecurityCoursePage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public WebElement wscourse() {
		
		return driver.findElement(websecuritycourse);
	}
	
}
