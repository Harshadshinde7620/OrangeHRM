package stepDefinations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModel.loginPage;
import pageObjectModel.SideMenuElementDashboard;
import utilities.webUtils;

public class StepDefination {
	
	private WebDriver driver= hooks.driver;
	private loginPage loginpage;
	private SideMenuElementDashboard sideMenuElement;
	
	//Constructor
	
	webUtils utils= new webUtils(driver);
	
	
	//Valid Login
	@Given("Admin is on the webpage")
	public void admin_is_on_the_webpage() {
		loginpage= new loginPage(driver);
	}

	@When("He enters {string}, {string} and clicks on login button")
	public void he_enters_and_clicks_on_login_button(String username, String password) {
		loginpage.login(username, password);
	}

	@Then("Admin is redirected to dashboard page.")
	public void admin_is_redirected_to_dashboard_page() {
		loginpage.getPageTitle();
	}

	//Invalid Login
	
    @Then("Admin see {string}")
    public void admin_see_error_message(String expectedErrorMessage) {
    	 utils.verifyGivenText(expectedErrorMessage);
    }
    
    
    //SideMenuOption
    //sideMenuVisibility
    @Given("Admin login into the portal using {string} , {string} and gets to dashboard")
    public void admin_login_into_the_portal(String username, String password) {
    	
    	System.out.println("Username recieved: " + username);
    	System.out.println("Password recieved: " + password);
    	
    	loginpage = new loginPage(driver);
    	loginpage.login(username, password);
    	
    	sideMenuElement = new SideMenuElementDashboard(driver);
    }
    
    @When("Admin verifies {string} options")
    public void admin_verifies_side_menu_option(String text) {

        Assert.assertTrue(
            sideMenuElement.verifyPresenceofElement(text).isDisplayed(),
            text + " is not displayed in side menu"
        );
    }
    @Then("{string} should be visible")
    public void side_menu_element_should_be_visible(String text) {
        Assert.assertTrue(
        		sideMenuElement.verifyPresenceofElement(text).isDisplayed()
        );
    }
    	
    //verifySideMenuPageTitle
  /* @Given("User logs into the admin account {string}, {string} and lands on the dashboard page")
    public void user_logs_into_the_admin_account_and_lands_on_the_dashboard_page(String string, String string2) {
       loginpage = new loginPage(driver);
       loginpage.login(string, string2);
       
       sideMenuElement= new SideMenuElementDashboard(driver);
       
    }*/

    @When("Admin clicks on the {string}")
    public void admin_clicks_on_the(String elementText) {
    	sideMenuElement= new SideMenuElementDashboard(driver);
     
    	sideMenuElement.clickonSideMenuElement(elementText);
    	
    }

    @Then("The page header should be {string}")
    public void the_page_header_should_be(String expectedPageHeader) {
    
    	String actualPageHeader= sideMenuElement.verifyPageTitelofSideMenuElement(expectedPageHeader);
    	Assert.assertEquals(actualPageHeader, expectedPageHeader, "Header Mismatch!");
    	
    }

    //SearchSideMenuElement
    //The Given step will same in the previous methods so no need to write this again.
    
    @When("Admin search on the {string}")
    public void admin_searches_on_the(String enterOption) {
    	sideMenuElement.searchSideMenuOption(enterOption);
    }

    @Then("Search should show the following {string}")
    public void search_should_show_the_following(String gotOption) {
    	String expectedSerachedOption= sideMenuElement.extractSearchedSideMenuOption(gotOption);
    	Assert.assertEquals(expectedSerachedOption, gotOption, "provided and searched option are missmatch");
    	
    }

    //BlankSearch
    
    @When("Admin blank search on the {string}")
    public void admin_blank_search_on_the(String enterOption) {
    	sideMenuElement.searchSideMenuOption(enterOption);
    }
   
    @Then("Search should show {string} of the options")
    public void search_should_show_of_the_options(String list) {

    	List<String> actualList= sideMenuElement.getListofMenuOptions();
    	List<String> expectedList= 
    			Arrays.stream(list.split(","))
    			.map(String::trim)
    			.collect(Collectors.toList());
    			
    	Assert.assertEquals(expectedList, actualList, "expected and actual list are mismatched");
    }

}
