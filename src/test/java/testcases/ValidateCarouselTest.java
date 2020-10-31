package testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.ValidateCarouselPage;
import testBase.Base;

public class ValidateCarouselTest extends Base{

	public WebDriver driver;
	
	@BeforeTest
	public void setUp() throws IOException {
	
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));		
	}
	
	@Test
	public void validateCarouselItems() {
		
		ValidateCarouselPage vcp=new ValidateCarouselPage(driver);
		List<WebElement> carouselitems=vcp.carouselitemsList();
		int itemcount=carouselitems.size();
		System.out.println(itemcount);
		
		for(int i=0; i<=itemcount; i++) {
			
			if(carouselitems.get(i).getText().equalsIgnoreCase("Practice Project")) {
				
				Assert.assertEquals(carouselitems.get(i).getText(), "Practice Project");
				//System.out.println(carouselitems.get(i).getText());
			}
			/*
			 * else if(carouselitems.get(i).getText().equalsIgnoreCase("Part-time Jobs")) {
			 * carouselitems.get(i).click();
			 * System.out.println(carouselitems.get(i).getText()); } else
			 * if(carouselitems.get(i).getText().equalsIgnoreCase("Mentorship")) {
			 * carouselitems.get(i).click();
			 * System.out.println(carouselitems.get(i).getText()); }
			 * 
			 * else if(carouselitems.get(i).getText().equalsIgnoreCase("Consulting")) {
			 * carouselitems.get(i).click();
			 * System.out.println(carouselitems.get(i).getText()); }
			 */
		
		}    
		    
		}
		
    @AfterTest
	public void tearDown() {
		
		//driver.close();
		driver.quit();
	}
}
