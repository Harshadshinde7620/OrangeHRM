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
      | Job             |
      | Organization    |
      | Qualifications  |
      | Configuration   |

  @NormalOptionsValidation
  Scenario: Verify normal clickable menu options in admin module
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then verify normal menu options
      | Nationalities      |
      | Corporate Branding |

  @UserManagmentDropDownOptions
  Scenario: Validate User Management dropdown options
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then I click on "User Management" module it should display the following options
      | Users |

  @JobDropDownOptions
  Scenario: Validate Job dropdown options
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then I click "Job" module it should display the following options
      | Job Titles        |
      | Pay Grades        |
      | Employment Status |
      | Job Categories    |
      | Work Shifts       |

  @OrganizationDropdownOptions
  Scenario: Validate Organization dropdown options
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then I click "Organization " it should display the following options
      | General Information |
      | Locations           |
      | Structure           |

  @QualificationsDropdownOptions
  Scenario: Validate Qualifications dropdown options
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then Click "Qualifications" it should display the following options
      | Skills      |
      | Education   |
      | Licenses    |
      | Languages   |
      | Memberships |

  @ConfigurationDropdownOptions
  Scenario: Validate Configuration dropdown options
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then Click on "Configuration" then it should display the following options
      | Email Configuration          |
      | Email Subscriptions          |
      | Localizations                |
      | Language Packages            |
      | Modules                      |
      | Social Media Authentications |
      | Register OAuth Client        |
      | LDAP Configuration           |

  #UserManagements Test Cases
  @ValidateSystemUser
  Scenario Outline: Validate System User in User Management sub module
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    When Admin clicks "Admin" and navigates to the Admin page
    Then Check the "<Username>", "<UserRole>", "<Suggestive Name>", "<Employee Name>", "<Status>", "<Result>"

    Examples: 
      | Username | UserRole | Suggestive Name | Employee Name      | Status  | Result            |
      | Admin    | Admin    | Leon            | Leon Scott Kennedy | Enabled | (1) Records Found |
