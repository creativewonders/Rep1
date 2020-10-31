package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public WebDriver driver;
	
	//Page Objects OR:
	By loginbtn=By.cssSelector("a.theme-btn.register-btn");
	By allcourses = By.xpath("//li[2]/a[@href='https://courses.rahulshettyacademy.com/courses']");
	
	public HomePage(WebDriver driver)
	{
		//using this keyword to assign the driver from HomePageTest
		//to the current class driver(HomePage)
		this.driver=driver;
	}
	
	public AllCoursesPage allCourses() {

		driver.findElement(allcourses).click();
		AllCoursesPage acp=new AllCoursesPage(driver);
		return acp;
	}
	
	public LoginPage loginBtn()
	{
		driver.findElement(loginbtn).click();
		LoginPage lp=new LoginPage(driver);
		return lp;
		
	}   
	
}
