package pageobjectmodel.adminPage.components;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.webUtils;

public class MenuComponents {
	
	private WebDriver driver;
	private webUtils utils;
	private WebDriverWait wait;
	
	
	private By allOptions = By.xpath("//nav[contains(@class,'oxd-topbar-body-nav')]//li");;
	private By dropdownOptions = By.xpath("//li[contains(@class,'--parent')]//span");
	private By normalClickOptions = By.xpath("//nav[contains(@class,'oxd-topbar-body-nav')]//li//a");
	

	public MenuComponents(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getAllOptions() {
		return driver.findElements(allOptions)
				.stream()
				.map(e -> e.getText().trim())
				.filter(text -> !text.isEmpty())
				.toList();
	}
	
	public List<String> getDropDownOptions(){
		return driver.findElements(dropdownOptions)
				.stream()
				.map(e->e.getText().trim())
				.filter(text -> !text.isEmpty())
				.toList();
	}
	
	public List<String> getnormalClickOptions(){
		return driver.findElements(normalClickOptions)
				.stream()
				.map(e->e.getText().trim())
				.filter(text->!text.isEmpty())
				.toList();
	}
	
	public List<String> getSubmoduleDropdownOptions(String moduleName) {
	    // Step 1: Click module
		By getdropdownOption= By.xpath("//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space(.)='" + moduleName + "']");
		WebElement dropdown= driver.findElement(getdropdownOption);
		dropdown.click();
		

	    // Step 1: Wait for drop down module
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> options= wait.until(
			    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[contains(@class,'oxd-dropdown-menu')]//li//a")));
		
		//Extract Text
		List<String> optionTexts= new ArrayList<>();
		
		for (WebElement option: options) {
			optionTexts.add(option.getText().trim());
		}
		return optionTexts;
	}
	
	
}