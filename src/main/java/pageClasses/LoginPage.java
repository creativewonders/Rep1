package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  {

	public WebDriver driver;
	//Page Objects OR:
	
	By username=By.id("user_email");
	By password=By.id("user_password");
	By signin=By.name("commit");
	By footertext=By.xpath("//footer/div[1]/div[1]/div[1]/p[contains(text(),'Rahul Shetty Academy')]");
    By createAcc=By.xpath("//a[contains(text(),'Create an Account')]");
    
    
    //Methods or Functions:

    public LoginPage(WebDriver driver){
    	
    	this.driver=driver;
	}

    public WebElement userName()
    {
    	return driver.findElement(username);
    }
    
    public WebElement pwd()
    {
    	return driver.findElement(password);
    }
    public PortalHomePage loginBtn()
    {
    	driver.findElement(signin).click();
    	PortalHomePage php=new PortalHomePage(driver);
    	return php;
    }
    public WebElement crecAcc()
    {
    	return driver.findElement(createAcc);
    }
    
    public String validateLoginPagetitle() {
    	return driver.getTitle();
    }
    
    public boolean validateFooterText() {
    	 return driver.findElement(footertext).isDisplayed();
    }
    
    
    
    
}
