package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import testUtil.TestUtil;

public class Base {

	/* 
	 * WebDriver  -done
	 * Properties -done
	 * Log4J2     -done, parallel execution problems
	 * Extent Reports - done
	 * Excel
	 * Mail
	 * DB
	 *  */
	
	public static WebDriver driver;
	public Properties prop;
	

	public WebDriver initializeDriver() throws IOException {
		String path=System.getProperty("user.dir");
		prop=new Properties();
		FileInputStream fis = new FileInputStream(
				path+"\\src\\main\\java\\config\\config.properties");
		prop.load(fis);
     
// When using config.prop file we use prop object of Properties class with the method get Property()
//prop.getProperty()
//		String browserName = prop.getProperty("browser");

// When we are parameterizing the choices of browser to use we do it from Jenkins
// and System.getProperty not prop
		
		String browserName = System.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
			path+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options= new ChromeOptions();
			
			if(browserName.equals("headless"))
			{	
             options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
             
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					path +"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}

		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		//driver.get(prop.getProperty("url"));
		
        return driver;		
		
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		
	TakesScreenshot ts= (TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destPathFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source, new File(destPathFile));
	return destPathFile;
				
	}
	
}
