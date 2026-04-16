package pageobjectmodel.adminPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.webUtils;

public class UserManagement {

	private WebDriver driver;
	private webUtils util;
	private WebDriverWait wait;
	
	//Elements
	By Username_loc= By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//input[@class='oxd-input oxd-input--active']");	
	By Userroledropdown_loc= By.xpath("//label[normalize-space()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
	
	By EmployeeName_loc= By.xpath("//input[@placeholder='Type for hints...']");
	By suggestionLists_loc=By.xpath("//input[@placeholder='Type for hints...']/../following-sibling::div");
	By Status_loc= By.xpath("//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
	
	By searchBtn = By.xpath("//button[normalize-space()='Search']");
	
	//Constructor
	
	public UserManagement(WebDriver driver) {
		this.driver=driver;
		util= new webUtils(driver);
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Action Method
	public void searchUser(String username, String userrole, String suggestiveName, String EmployeeName, String status, String result) {
		
		//find the username filed
		wait.until(ExpectedConditions.presenceOfElementLocated(Username_loc)).sendKeys(username);
		
		//find the dropdown and click it
		wait.until(ExpectedConditions.visibilityOfElementLocated(Userroledropdown_loc)).click();
		
		//find the UI element of the dropdown
		By userrole_loc=By.xpath("//div[@role='listbox']//span[normalize-space()='" + userrole +"']");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userrole_loc));
		
		//click the userrole options
		driver.findElement(userrole_loc).click();
		
		//Enter the name of employee
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeName_loc)).sendKeys(suggestiveName);
		
		//Wait for the suggestion in the dropdown
		//wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionLists_loc));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> options= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestionLists_loc));
		
		//for loop to select the corrcet option
		for(WebElement option:options) {
			
			if(option.getText().contains(EmployeeName)) {
				option.click();
				break;
			}
		}
		
		//Find the status filed and click on it
		wait.until(ExpectedConditions.visibilityOfElementLocated(Status_loc)).click();
		
		//Click the status 
		By statusOptions_loc= By.xpath("//div[@role='listbox']//span[normalize-space()='"+ status +"']");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(statusOptions_loc));
		
		//Select the status
		driver.findElement(statusOptions_loc).click();
		
		//Click the serach button
		driver.findElement(searchBtn).click();
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Check the result
		By result_loc=By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(result_loc));
		
		String actualResult= driver.findElement(result_loc).getText();
		
		if(actualResult.contains("(1)")) {
			Assert.assertTrue(actualResult.contains("Record Found"));
		}
		else {
			Assert.assertTrue(actualResult.contains("Records Found"));
		}
		
		System.out.println("Actual result: " + actualResult);
		
		
	}
	
}
