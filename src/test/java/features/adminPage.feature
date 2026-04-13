Feature: Admin Page Functionality

  @AdminModuleNameVerification
  Scenario: Verfiy the page title of the Admin Page once we are on it.
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then verfiies the main module name to be "Admin"

  @AdminSubModuleNameVerification
  Scenario: Verfiy the sub module title of the Admin Page once we are on it.
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then verfies the sub module name "User Management"

 #User Managemnet Options
  @AllMenuOptionsValidation
    Scenario: Verify all admin menu options are displayed correctly
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then verify all admin menu options
      | User Management    |
      | Job                |
      | Organization       |
      | Qualifications     |
      | Nationalities      |
      | Corporate Branding |
      | Configuration      |


  @DropdownOptionsValidation
  Scenario: Verify dropdown menu options in admin module
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then verify dropdown menu options
      | User Management |
      | Job            |
      | Organization   |
      | Qualifications |
      | Configuration  |


  @NormalOptionsValidation
  Scenario: Verify normal clickable menu options in admin module
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then verify normal menu options
      | Nationalities      |
      | Corporate Branding |


  @PrintMenuOptions
  Scenario: Print all admin menu options for debugging
    Then print all admin menu options
