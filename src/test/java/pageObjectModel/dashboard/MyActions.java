package pageobjectmodel.dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.webUtils;

public class MyActions {

	private WebDriver driver;
	private WebDriverWait wait;
	private webUtils utils;
	
	
	//Elements
	By pendingReview_loc= By.xpath("//p[contains(@class,'oxd-text oxd-text--p') and normalize-space()='(1) Pending Self Review']");
	By candidateInterview_loc= By.xpath("//p[contains(@class,'oxd-text oxd-text--p') and normalize-space()='(1) Candidate to Interview']");
	
	//constructor
	public MyActions(WebDriver driver) {
		this.driver= driver;
		this.utils= new webUtils(driver);
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	

	//Action Methods
	public boolean myActionsWidgetVisibility(String text) {
		WebElement locator= utils.getDashBoardElementWithText(text);
		return wait.until(ExpectedConditions.visibilityOf(locator)).isDisplayed();
	}
	
	public void verfiyPageTitleofMyActionsWidgetLink1Page() {
		utils.clickElement(pendingReview_loc);
		utils.extractPageTitle();
		return;
	}

	
}
