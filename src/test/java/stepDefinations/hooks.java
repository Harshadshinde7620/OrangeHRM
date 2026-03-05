package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hooks {
	
	public static WebDriver driver;

		@Before
		//This will run before every scenario
	public void browserSetup() {
		
		System.out.println("I am inside the application");
		
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

		
	}
		@After
		//This will run after every scenario
	public void teardown() {
			System.out.println("I am outside the application");
			if(driver != null) {
				//driver.quit();
			}
		}
	
	@AfterStep
	public void afterTestAction(Scenario scenario) {
		if (scenario.isFailed()) {

	        byte[] screenshot = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.BYTES);

	        scenario.attach(screenshot, "image/png", scenario.getName());
	    }	
	
	}
		
	}

