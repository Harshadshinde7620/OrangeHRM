package utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import stepDefinations.hooks;


public class webUtils{

	 WebDriver driver;
	 WebDriverWait wait; 
	 
	 //To inject the WebDriver dependency into the utility class so that all utility methods operate on the same browser session and to maintain loose coupling and scalability in the framework.
	
	 //constructor
	 
	 public webUtils(WebDriver driver) {
		 this.driver= driver;
		 this.wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	 }
	
	public void enterText(By element, String text) {
		WebElement ele= wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		ele.clear();
		ele.sendKeys(text);
	}
	
	public void clickElement(By elementText) {
		wait.until(ExpectedConditions.elementToBeClickable(elementText)).click();
	
	}
	
	public  String extractPageTitle() {
		return driver.getTitle();
	}
		
	public String getText(By element) {
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText().trim();
		
	}
	
	public void createLocatorWithText(By elementText) {
		
		String locator= "//*[text()='"+elementText+"']";
		
	}
	
	public WebElement getSideMenuElementWithText(String text) {
		/*By elementLocator= By.xpath("//span[normalize-space(text())='"+ text + "']");
		return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));*/
		By elementLocator= By.xpath("//span[contains(@class,'oxd-main-menu-item--name') and normalize-space(.)='" + text + "']");
		return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}
	
	
	
	public WebElement getDashBoardElementWithText(String text) {
		
		By locator = By.xpath("//p[normalize-space()='" + text + "']");
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public String getAdminPageHeader() {
		By locator= By.xpath("//h6[contains(@class,'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	
		return driver.findElement(locator).getText().trim();
	}
	
	
	public void verifyGivenText(String text) {
		
		
		String ActualText= driver.findElement(By.xpath("//*[text()='"+text+"']")).getText().trim();
		
		Assert.assertEquals(ActualText, text);
	}
	
	public void verifyContainsText(String text) {
		
		
		String ActualText= driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]")).getText().trim();
		
		Assert.assertTrue(ActualText.contains(text));
	}

	public List<WebElement> getListOfElements(By locator) {
		
		List<WebElement> elementList= driver.findElements(locator);
		return elementList;
		
	}

	public List<String> getTextFromList(By Locator){
		
		List<WebElement> elementList= driver.findElements(Locator);
		List<String> texts= new ArrayList<>();
		
		for(WebElement elements:elementList) {
			texts.add(elements.getText());
		}
		return texts;
	}

	public boolean isElementPresent(By element, int i) {
		// TODO Auto-generated method stub
		return false;
	}
}
