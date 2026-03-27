package pageobjectmodel.dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.webUtils;

public class TimeAtWorkWidget {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private webUtils utils;
	
	//Elements
	
	
	//Title of widget
	private By widgetTitle_loc= By.xpath("//p[@class='oxd-text oxd-text--p' and text()='Time at Work']");
	private By widgetStopwatch_loc= By.xpath("//button[@class='oxd-icon-button oxd-icon-button--solid-main orangehrm-attendance-card-action']");
	
	
	//constructor
	public TimeAtWorkWidget(WebDriver driver) {
		this.driver= driver;
		this.utils= new webUtils(driver);
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	//Action Methods
	public boolean checkTAWWidgetVisibility(String text) {
		WebElement locator= utils.getDashBoardElementWithText(text);
		return wait.until(ExpectedConditions.visibilityOf(locator)).isDisplayed();
	}
	
	public String getTAWTitle() {
		return utils.getText(widgetTitle_loc);
	}
	
	public void clickOnTAWStopWatch() {
		utils.clickElement(widgetStopwatch_loc);
		utils.extractPageTitle();
		return;
	}
	
}
