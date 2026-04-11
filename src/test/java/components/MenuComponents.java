package components;

import java.util.List;
import org.openqa.selenium.*;

public class MenuComponents {
	
	private WebDriver driver;

	private By allOptions = By.xpath("//li[contains(@class,'oxd-topbar-body-nav-tab')]//*[self::span or self::a]");
	private By dropdownOptions = By.xpath("//li[contains(@class,'--parent')]//span");
	private By normalClickOptions = By.xpath("//li[not(contains(@class,'--parent'))]//a");

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
}