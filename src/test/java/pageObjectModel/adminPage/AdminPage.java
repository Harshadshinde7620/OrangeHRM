package pageobjectmodel.adminPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import components.MenuComponents;
import utilities.webUtils;

public class AdminPage {

	private WebDriver driver;
	private webUtils utils;
	private WebDriverWait wait;
	
	private MenuComponents menu;
	
	
	private By mainModuleName_loc= By.xpath("//span[@class='oxd-topbar-header-breadcrumb']//h6[text()='Admin']");
	private By usersubModuleName_loc= By.xpath("//span[@class='oxd-topbar-header-breadcrumb']//h6[text()='User Management']");
	
	
	//Constructor driver ko page class ke andar inject karta hai.
	//Tumhare framework mein:
	//WebDriver object test class mein create hota hai
	//Page class ko bhi driver chahiye hota hai
	//Toh driver ka reference kaise pass kare?
	//👉 Constructor se
	
	public AdminPage(WebDriver driver) {
	    this.driver = driver;
	    utils = new webUtils(driver);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    menu = new MenuComponents(driver); // ✅ CORRECT
	}
	
	//ACtion Methods
	
	public String getAdminModule() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(mainModuleName_loc)).getText();
	}
	
	public String getAdminSubModuleName() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(usersubModuleName_loc)).getText();
	}
	
	public WebElement waitForAdminSubModule() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(usersubModuleName_loc));
	}
	
	public List<String> getallOptions(){
		return menu.getAllOptions();
	}
	
	public List<String> getdropdownOptions(){
		return menu.getDropDownOptions();
	}
	
	public List<String> getclickableOptions(){
		return menu.getnormalClickOptions();
	}
}
