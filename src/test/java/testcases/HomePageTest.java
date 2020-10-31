package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageClasses.HomePage;
import pageClasses.LoginPage;
import pageClasses.PortalHomePage;
import testBase.Base;
import testUtil.TestUtil;

public class HomePageTest extends Base {

	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException{
		
		driver = initializeDriver();
        driver.get(prop.getProperty("url"));		
		log.info("Driver initialized and navigated to home page");
	}
		
	@Test
	public void HomeTest() {
		

		HomePage hp = new HomePage(driver);
		
		LoginPage lp = hp.loginBtn();

		String pageTtitle = lp.validateLoginPagetitle();

		Assert.assertEquals(pageTtitle, "Rahul Shetty Academy");

		Boolean fttxt = lp.validateFooterText();
		Assert.assertTrue(fttxt, "Rahul Shetty Academy");

		lp.userName().sendKeys(prop.getProperty("username"));
		lp.pwd().sendKeys(prop.getProperty("password"));
		PortalHomePage php = lp.loginBtn();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		String enrolledCourse = php.validateEnrolledCourse();
		Assert.assertEquals(enrolledCourse, "Write effective QA Resume that will turn to interview call");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
//		driver.close();
	}

}
