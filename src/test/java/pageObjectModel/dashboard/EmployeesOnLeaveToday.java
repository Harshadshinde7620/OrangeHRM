package pageobjectmodel.dashboard;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.webUtils;

public class EmployeesOnLeaveToday {
	
	private WebDriver driver;
	private WebDriverWait waits;
	private webUtils utils;
	
	
	//Elements
	private By noEmployeeMessage= By.xpath("//p[contains(., 'No Employees are on Leave Today')]");
	private By employeeNamesList = By.xpath(
			"//div[contains(@class,'orangehrm-dashboard-widget')]//p[contains(@class,'oxd-text--p') "
			+ "and not(contains(.,'No Employees'))]");
	
	//constructor
	public EmployeesOnLeaveToday(WebDriver driver) {
		this.driver= driver;
		this.waits= new WebDriverWait (driver, Duration.ofSeconds(10));
		this.utils= new webUtils(driver);
	}
	
	//Action Methods
	
	//Check if no employees is on leave message correctly.
	
	public Boolean EmployeesOnLeaveTodayEmptyMessgae(String expectedText) {
		
		try {
		String actualText= utils.getText(noEmployeeMessage);
		
		return actualText.contains(expectedText);
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean EmployeesOnLeaveTodayEmployeeName(String expectedName) {
		
		if(utils.isElementPresent(noEmployeeMessage, 5)) {
			System.out.println("No Employees are on Leave Today");
			return false;
		}
		
		List<String> names= utils.getTextFromList(employeeNamesList);
		
		System.out.println("Employees name in UI " + names);
		
		return names.stream().anyMatch(name->name.trim().equalsIgnoreCase(expectedName));
	}

}
