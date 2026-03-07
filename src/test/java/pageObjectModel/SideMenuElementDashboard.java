package pageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.webUtils;

public class SideMenuElementDashboard {
		
		//We are going to use the create locator with text method from web utilities
		
		private WebDriver driver;
		private webUtils utils;
		private WebDriverWait wait; 
		
		
		By searchPlaceholder_loc=By.xpath("//input[@placeholder='Search']");
		By searchedElement_loc= By.xpath("//span[contains(@class,'oxd-text oxd-text--span oxd-main-menu-item--name')]");
		By combineMenuOptions_loc= By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']");
		
		
		//Constructor
		public SideMenuElementDashboard(WebDriver driver) {
			this.driver= driver;
			this.utils= new webUtils(driver);
		    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			}
		//ActionMethods
		
		public WebElement verifyPresenceofElement(String text) {
			
			return utils.getSideMenuElementWithText(text);
			
		}

		public String verifyPageTitelofSideMenuElement(String text) {
			By header = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]");
			return wait.until(ExpectedConditions.visibilityOfElementLocated(header)).getText().trim();
		}
		
		public void clickonSideMenuElement(String elementName) {
			By locator= By.xpath("//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name') and normalize-space()= '"+elementName+"']");
			 wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		}
		
		public void searchSideMenuOption(String text) {
			//By searchPlaceholder_loc= By.xpath("//input[@placeholder='Search']");
			wait.until(ExpectedConditions.presenceOfElementLocated(searchPlaceholder_loc)).sendKeys(text);
			
		}
		
		public String extractSearchedSideMenuOption(String text) {
			return utils.getText(searchedElement_loc);
		}
		
		public List<String> getListofMenuOptions(){
			return utils.getTextFromList(combineMenuOptions_loc);

		}

}


