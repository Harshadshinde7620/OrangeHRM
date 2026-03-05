package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.webUtils;

public class AdminPage {

	WebDriver driver;
	webUtils utils;
	
	//Constructor driver ko page class ke andar inject karta hai.
	//Tumhare framework mein:
	//WebDriver object test class mein create hota hai
	//Page class ko bhi driver chahiye hota hai
	//Toh driver ka reference kaise pass kare?
	//👉 Constructor se
	
	public AdminPage(WebDriver driver) {
		this.driver= driver;
		utils= new webUtils(driver);
	}
	
	
}
