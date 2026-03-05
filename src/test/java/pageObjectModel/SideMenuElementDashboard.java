package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.webUtils;

public class SideMenuElementDashboard {
		
		//We are going to use the create locator with text method from webutilities
		
		private WebDriver driver;
		private webUtils utils;
		
		
		By placeholder_loc=By.xpath("//input[@placeholder='Search']");
		By searchedElement_loc= By.xpath("//span[contains(@class,'oxd-text oxd-text--span oxd-main-menu-item--name')]");
		
		//Constructor
		public SideMenuElementDashboard(WebDriver driver) {
			this.driver= driver;
			this.utils= new webUtils(driver);
			
			}
		//ActionMethods
		
		public WebElement verifyPresenceofElement(String text) {
			
			return utils.getSideMenuElementWithText(text);
			
		}

		public String verifyPageTitelofSideMenuElement(String text) {
			return utils.getSideMenuPageHeader(text);
		}
		
		public void clickonSideMenuElement(String elementText) {
			utils.clickSideMenuElement(elementText);
			
		}
		
		public void searchSideMenuOption(By element, String text) {
			utils.enterText(placeholder_loc, text);
		}
		
		public String extractSearchedSideMenuOption(String text) {
			return utils.getText(searchedElement_loc);
		}
}


