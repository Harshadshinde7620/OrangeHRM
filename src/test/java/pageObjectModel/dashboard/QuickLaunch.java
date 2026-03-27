package pageobjectmodel.dashboard;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.webUtils;

public class QuickLaunch {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private webUtils utils;
	
	//Elements
	
	
	//constructor
	
	public QuickLaunch(WebDriver driver) {
		this.driver= driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		this.utils= new webUtils(driver);
	}
	
	
	//Action Methods
	public boolean quickLaunchWidgetVisibility(String text) {
		WebElement element= utils.getDashBoardElementWithText(text);
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}
	
	public int quickLaunchWidgetClickablelinks() {
		List<WebElement> links=driver.findElements(By.xpath("//div[contains(@class,'orangehrm-quick-launch')]//p"));
		return links.size();
	}
	
	public List<String> quickLaunchWidgetLinksTexts(){
		List<WebElement> links=driver.findElements(By.xpath("//div[contains(@class,'orangehrm-quick-launch')]//p"));
		
		List<String> names= new ArrayList<>();
		
		for (WebElement e: links) {
			names.add(e.getText());
		}
		return names;	
	}
	
	
	public void quickLaunchLinksPageTitles(String links, String expectedPageTitle) {
		
		By locator= By.xpath("//button[@title='" + links + "']");
		utils.clickElement(locator);
		
		String actualPageTitle= utils.getAdminPageHeader();
		
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
//				" Expected Title " + expectedPageTitle + " but found " + actualPageTitle);
	}
}
