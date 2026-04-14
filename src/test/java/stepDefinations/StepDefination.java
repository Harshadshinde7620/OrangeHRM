package stepDefinations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.SideMenuElementDashboard;
import pageobjectmodel.loginPage;
import pageobjectmodel.adminPage.AdminPage;
import pageobjectmodel.dashboard.BuzzLatestPosts;
import pageobjectmodel.dashboard.EmployeesOnLeaveToday;
import pageobjectmodel.dashboard.MyActions;
import pageobjectmodel.dashboard.QuickLaunch;
import pageobjectmodel.dashboard.TimeAtWorkWidget;
import utilities.webUtils;

public class StepDefination {
	
	private WebDriver driver= hooks.driver;
	private loginPage loginpage;
	private List<String> expectedlist;
	
	private SideMenuElementDashboard sideMenuElement;
	
	private TimeAtWorkWidget tawWidget;
	
	private MyActions myactions;
	
	private QuickLaunch quickLaunch;
	
	private BuzzLatestPosts buzzLatestPosts;
	
	private EmployeesOnLeaveToday employeesonLeaveToday;
	
	private AdminPage adminPage;
	
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

    
    //Visibility of side Menu
    
    @When("Admin looks for the {string}")
    public void admin_looks_for_the(String list) {
    	List<String> expectedList= 
    			Arrays.stream(list.split(","))
    			.map(String::trim)
    			.collect(Collectors.toList());
    }

    @Then("Search should show {string}")
    public void search_should_show(String list) {
    	List<String> actualList=sideMenuElement.getListofMenuOptions();
    	
    	Assert.assertEquals(actualList, expectedlist, "expected and actual list are mismatched");
    	
    }
    
    //DashBoard Pages
    
    //TimeAtWorkWidget
    
    @Given("Admin logs into the OrangeHRM portal using {string} , {string}")
    public void admin_logs_into_the_orange_hrm_portal_using(String username, String password) {

    	System.out.println("Username recieved: " + username);
    	System.out.println("Password recieved: " + password);
    	
    	loginpage = new loginPage(driver);
    	loginpage.login(username, password);
    }
    
    @When("Admin navigates to the dashboard page")
    public void admin_navigates_to_the_dashboard_page() {
      
    }
    
    
    @Then("{string} widget should be visible")
    public void widget_should_be_visible(String string) {
 	tawWidget = new TimeAtWorkWidget(driver);
    	Assert.assertTrue(tawWidget.checkTAWWidgetVisibility(string));
    }
    
    //TimeAtWorkWidgetStopWatchPage
    
    @Then("Admin clicks on the stopwatch and gets to Attendance page.")
    public void admin_clicks_on_the_stopwatch_and_gets_to_Attendance_page() {
    	tawWidget = new TimeAtWorkWidget(driver);
    	tawWidget.clickOnTAWStopWatch();
    }
    
    //MyActionsWidgetVIsibility
    
    @Then("{string} widget must be visible")
    public void my_actions_widget_must_be_visible(String text) {
    	myactions= new MyActions(driver);
    	Assert.assertTrue(myactions.myActionsWidgetVisibility(text));
    }
    
    //MyActionsWidgetLink1Page
    @Then("Admin verfies the page title to be Performance page upon click of link1")
    public void admin_verfies_the_page_title_to_be_performance_page_upon_click_of_link1() {
       myactions= new MyActions (driver);
       myactions.verfiyPageTitleofMyActionsWidgetLink1Page();
    }
    
    //QuicklaunceWidgetVisibility
    @Then("{string} widget is visible")
    public void widget_is_visible(String widgetName) {
       quickLaunch = new QuickLaunch(driver);
       quickLaunch.quickLaunchWidgetVisibility(widgetName);   
    }
   
    @Then("Admin verfies {string} and its {string} of the widget")
    public void admin_verfies_and_its_of_the_widget(String links, String pageTitles) {
    	quickLaunch= new QuickLaunch(driver);
    	quickLaunch.quickLaunchWidgetClickablelinks();
    	quickLaunch.quickLaunchLinksPageTitles(links, pageTitles);
    	
    }
    
    //BuzzLatestPostWidgetVisibility
    @Then("Verify visibility of {string} widget")
    public void verify_visibility_of_widget(String widgetName) {
    	buzzLatestPosts= new BuzzLatestPosts(driver);
    	buzzLatestPosts.BuzzLatestPostWidgetVisibility(widgetName);
    }
    
    //BuzzLatestPostWidgetClickableLinks
    @Then("Verify number of clickable links in {string} widget is {int}")
    public void verify_number_of_clickable_links_in_widget(String widgetName, int expectedCount) {
    	buzzLatestPosts= new BuzzLatestPosts(driver);
    	buzzLatestPosts.BuzzLatestPostWidgetClickableLinks();
    }
    
    //BuzzLatestPostWidgetClickableLinksAlongWithUsernames
    @Then("Verify {string} is present as clickable user in Buzz Latest Posts widget")
    public void verify_clickable_usernames(String userName) {
    	buzzLatestPosts= new BuzzLatestPosts(driver);
    	
    	//Now We have to find the list of actual users 
    	List <String> actualUsers= buzzLatestPosts.getBuzzUsernames();
    	
    	System.out.println("UI users are: " + actualUsers);
    	
    	Assert.assertTrue(actualUsers.contains(userName), "User are not found in the Buzz widget :" +userName);
    	
    }

    //EmployeesOnLeaveToday
    
    //EmployeesOnLeaveTodayEmptyMessgae
    @Then("Verify {string} present.")
    public void verify_present(String expectedMessage) { 
    	employeesonLeaveToday= new EmployeesOnLeaveToday(driver);
    	employeesonLeaveToday.EmployeesOnLeaveTodayEmptyMessgae(expectedMessage);
    }
    
    
    //EmployeesOnLeaveTodayEmployeeName
    @Then("Verify {string} if it is present in the widget")
    public void verifyEmployeeNameInLeaveWidget(String employeeName) {
    
    	employeesonLeaveToday = new EmployeesOnLeaveToday(driver);
    	Boolean isPresent= employeesonLeaveToday.EmployeesOnLeaveTodayEmployeeName(employeeName);
    	
    	System.out.println("Employee on leave today is " + isPresent);
    	
        Assert.assertTrue(isPresent,
                "❌ Employee NOT found in widget: " + employeeName);
    }

    
    //Admin page
    
    //Admin Page sub module test cases
    //AdminModuleNameVerification
    @When("Admin clicks {string} and navigates to the Admin page")
    public void admin_clicks_and_navigates_to_the_admin_page(String elementText) {
    	sideMenuElement= new SideMenuElementDashboard(driver);   
    	adminPage= new AdminPage(driver);
    	
    	sideMenuElement.clickonSideMenuElement(elementText);
    	adminPage.waitForAdminSubModule();
    }

    @Then("verfiies the main module name to be {string}")
    public void verfiies_the_main_module_name_to_be(String expectedModule) {
    	adminPage= new AdminPage(driver);
    	
    	String actaulModule= adminPage.getAdminModule();
    	Assert.assertEquals(actaulModule, expectedModule);
    }

    //AdminSubModuleNameVerification
    @Then("verfies the sub module name {string}")
    public  void verify_sub_module_name(String expectedSubModule) {
    	adminPage= new AdminPage(driver);
    	String actualSubModule= adminPage.getAdminSubModuleName();
    	System.out.println("Name of the sub module is " + actualSubModule);
    	Assert.assertEquals(actualSubModule, expectedSubModule);
    }
  
    // ------------------- ALL MENU OPTIONS -------------------
    //AllMenuOptionsValidation
    @Then("verify all admin menu options")
    public void verify_all_admin_menu_options(DataTable dataTable) {
    	adminPage= new AdminPage(driver);
    	
    	List<String> expectedOptions= dataTable.asList();
    	List<String> actualOptions= adminPage.getallOptions();
    	
    	//Collections.sort(expectedOptions);
    	//Collections.sort(actualOptions);
    	
    	System.out.println("Actual Options(UI): " + actualOptions);
    	System.out.println("Expected Options(Feature): " + expectedOptions);
    	System.out.println("Actual Options Number(UI):" + actualOptions.size());
    	
    	Assert.assertEquals(actualOptions, expectedOptions, "All Menu Mismatches");
    }
    // ------------------- ALL DropDown OPTIONS -------------------
    //DropdownOptionsValidation
  
    @Then("verify dropdown menu options")
    public void verify_dropdown_menu_options(DataTable dataTable) {
    	adminPage= new AdminPage(driver);
    	
    	List<String> expectedOptions= dataTable.asList();
    	List<String> actualOptions= adminPage.getdropdownOptions();
    	
    	System.out.println("Actual Options [UI]: " + actualOptions);
    	System.out.println("Expected Options[Feature]: " + expectedOptions);
    	System.out.println("Actual Options [UI] size:" + actualOptions.size());
    	
    	Assert.assertEquals(actualOptions, expectedOptions, "All Menu Options Mismatches");
    }
    // ------------------- ALL DropDown OPTIONS -------------------
    //NormalOptionsValidation
    @Then("verify normal menu options")
    public void verify_normal_menu_options(DataTable dataTable) {
    	adminPage= new AdminPage(driver);
    	List<String> expectedOptions= dataTable.asList();
    	List<String> actualOptions= adminPage.getclickableOptions();
    	
    	Assert.assertEquals(actualOptions, expectedOptions, "All Menu Options Mismatches");
    }
    //-------------------Get User Management DropDown Options----------
    //UserManagmentDropDownOptions
    @Then("I click on {string} module it should display the following options")
    public void validateUserManagementDropdownOptions(String moduleName, DataTable dataTable) {
    	adminPage= new AdminPage(driver);
    	List<String> expectedOptions= dataTable.asList();
    	List<String> actualOptions= adminPage.getSubModuleDropDownOptions(moduleName);	
    	System.out.println("Actual Options [UI]: " + actualOptions);
    	System.out.println("Expected Options[Feature]: " + expectedOptions);
    	System.out.println("Actual Options [UI] size:" + actualOptions.size());
    	
    }
    
    //JobDropDownOptions
    @Then("I click {string} module it should display the following options")
    public void validateJobDropdownOptions(String moduleName, DataTable dataTable) {
    	adminPage= new AdminPage(driver);
    	List<String> expectedOptions= dataTable.asList();
    	List<String> actualOptions= adminPage.getSubModuleDropDownOptions(moduleName);	
    	System.out.println("Actual Options [UI]: " + actualOptions);
    	System.out.println("Expected Options[Feature]: " + expectedOptions);
    	System.out.println("Actual Options [UI] size:" + actualOptions.size());
    	
    }
    //OrganizationDropdownOptions
    @Then("I click {string} it should display the following options")
    public void validateOrganizationDropdownOptions(String modulName, DataTable dataTable) {
    	adminPage= new AdminPage(driver);
    	List<String> expectedOptions= dataTable.asList();
    	List<String> actualOptions= adminPage.getSubModuleDropDownOptions(modulName);	
    	System.out.println("Actual Options [UI]: " + actualOptions);
    	System.out.println("Expected Options[Feature]: " + expectedOptions);
    	System.out.println("Actual Options [UI] size:" + actualOptions.size());
    	
    }

    //QualificationsDropdownOptions
    @Then("Click {string} it should display the following options")
    public void click_qualifications_and_validate_options(String menuOption, io.cucumber.datatable.DataTable dataTable) {
    	adminPage= new AdminPage(driver);
    	List<String> expectedOptions= dataTable.asList();
    	List<String> actualOptions= adminPage.getSubModuleDropDownOptions(menuOption);	
    	System.out.println("Actual Options [UI]: " + actualOptions);
    	System.out.println("Expected Options[Feature]: " + expectedOptions);
    	System.out.println("Actual Options [UI] size:" + actualOptions.size());
    }
    
    //ConfigurationDropdownOptions
    @Then("Click on {string} then it should display the following options")
    public void validate_configuration_dropdown(String menuOption, DataTable dataTable) {
    	adminPage= new AdminPage(driver);
    	List<String> expectedOptions= dataTable.asList();
    	List<String> actualOptions= adminPage.getSubModuleDropDownOptions(menuOption);	
    	System.out.println("Actual Options [UI]: " + actualOptions);
    	System.out.println("Expected Options[Feature]: " + expectedOptions);
    	System.out.println("Actual Options [UI] size:" + actualOptions.size());
    }

    
    
    
}
