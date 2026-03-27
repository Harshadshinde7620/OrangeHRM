package pageobjectmodel.dashboard;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.webUtils;

public class BuzzLatestPosts {

	
	private WebDriver driver;
	private WebDriverWait wait;
	private webUtils utils;
	
	//Element
	private By buzzUsers_loc= By.xpath("//div[@class='orangehrm-buzz-widget-header']");	
	
	//constructor
	
	public BuzzLatestPosts(WebDriver driver) {
		this.driver= driver;
		this.utils= new webUtils(driver);
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	//Action Methods
	public boolean BuzzLatestPostWidgetVisibility(String text) {
		WebElement locator= utils.getDashBoardElementWithText(text);
		return wait.until(ExpectedConditions.visibilityOf(locator)).isDisplayed();
	}
	
	public int BuzzLatestPostWidgetClickableLinks() {
		List<WebElement> links= driver.findElements(buzzUsers_loc);
		return links.size();	
	}
	
	public List<String> BuzzLatestPostWidgetClickableLinksAlongWithUsernames(String text) {
		List<WebElement> links= driver.findElements(buzzUsers_loc);
		
		List<String> names= new ArrayList<>();
		
		for(WebElement e: links) {
			names.add(e.getText());
		}
		
		return names;
		
	}
}
