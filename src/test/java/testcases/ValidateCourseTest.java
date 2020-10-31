package testcases;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.AllCoursesPage;
import pageClasses.HomePage;
import pageClasses.WebSecurityCoursePage;
import testBase.Base;

public class ValidateCourseTest extends Base  {

	 public WebDriver driver;
	 public static Logger log=LogManager.getLogger(Base.class.getName());
	 
	 @BeforeTest
	 public void setUp() throws IOException {
		 
		 driver=initializeDriver();
		 driver.get(prop.getProperty("url"));		
		 log.info("Driver initialized and navigated to homepage");
	 	 }

     @Test
     public void validateCourse() {
    	     	 
    	 HomePage hp=new HomePage(driver);
    	 AllCoursesPage acp=hp.allCourses();
    	 
    	 List<WebElement> courseList;
    	 courseList=acp.courseSearch();
    	 
    	 
    	 for(int i=0; i<=courseList.size();i++)
    	 {
    		 if(courseList.get(i).getText().equalsIgnoreCase("Web Security/Penetration Testing for Beginners")) {
    			 
    			 courseList.get(i).click();
    			 System.out.println(courseList.get(i).getText());
    			 break;
    			 
    		 }
    	 }
    	 log.info("Clicked on Web Security course");
    	 
    	 WebSecurityCoursePage wsp=new WebSecurityCoursePage(driver);
    	 String actualtxt=wsp.wscourse().getText();
    	 System.out.println(actualtxt);
    	 Assert.assertEquals(actualtxt, "**********Its Time to Protect our Websites from Security Attacks *************************");
    	 log.info("Course title displayed validated with the expected");
     }

     
     @AfterTest
     public void tearDown() {
    	 
    	 driver.quit();
    	 //driver.close();
    	 log.info("Quitting browser");
     }





}
