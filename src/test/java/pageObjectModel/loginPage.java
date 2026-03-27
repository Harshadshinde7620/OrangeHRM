package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.webUtils;

public class loginPage {

	WebDriver driver;
	webUtils utils;
	WebDriver wait;
	
	
	//Constructor driver ko page class ke andar inject karta hai.
	//Tumhare framework mein:
	//WebDriver object test class mein create hota hai
	//Page class ko bhi driver chahiye hota hai
	//Toh driver ka reference kaise pass kare?
	//👉 Constructor se
	
	public loginPage(WebDriver driver) {
		this.driver= driver;
		utils= new webUtils(driver);
	}
	
	//Elements Locators
	private By username_loc= By.xpath("//input[@name='username']");
	private By password_loc= By.xpath("//input[@name='password']");
	private By login_btn= By.xpath("//button[@type='submit']");
	private By forgetPassword_loc= By.xpath("//p[normalize-space()='Forgot your password?']");
	
	//Error Element Locators
	private By blankCreds_loc=By.xpath("//span[normalize-space()='Required']");
	private By invalidCreds_loc=By.xpath("//p[normalize-space()='Invalid credentials']");
	
	
	
	//Action Methods
	public void login(String Username, String Password) {
		utils.enterText(username_loc, Username);
		utils.enterText(password_loc, Password);
	    utils.clickElement(login_btn);
	}

	public void getPageTitle() {
		System.out.print(utils.extractPageTitle());
	}
}
