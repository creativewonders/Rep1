package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PortalHomePage {

	public WebDriver driver;
	
	By enrolledCourse=By.xpath("//div[@class='course-listing-title']");
	
	public PortalHomePage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public String validateEnrolledCourse() {
		
		return driver.findElement(enrolledCourse).getText();
	}
}
