package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllCoursesPage {

	public WebDriver driver;

	// Page Objects OR:

//	By allcourses = By.xpath("//ul[@class='navigation clearfix']/li[2]/a");
//	By inputtxtbox = By.cssSelector("input#search-courses");
//	By searchbtn = By.cssSelector("button#search-course-button");
//	By courselist = By.cssSelector("div.row.course-list.list");
	By searchcourses = By.xpath("//div[@class='row course-list list']/div/div/div/a/div[1]/div[2]");

	public AllCoursesPage(WebDriver driver) {

		this.driver = driver;

	}

	/*
	 * public WebElement allCourses() {
	 * 
	 * return driver.findElement(allcourses); }
	 * 
	 * public WebElement inputTextBox() {
	 * 
	 * return driver.findElement(inputtxtbox); }
	 * 
	 * public WebElement searchButton() {
	 * 
	 * return driver.findElement(searchbtn); }
	 * 
	 * public WebElement listOfCourses() {
	 * 
	 * return driver.findElement(courselist); }
	 */
	public List<WebElement> courseSearch() {

		return driver.findElements(searchcourses);
	}
}
