Feature: Dashboard side menu validations

  #Background:
  #  Given Admin login into the portal using "Admin" , "admin123" and gets to dashboard
  # @sideMenuVisibility
  #Scenario Outline: Check visibility of all elements in the side menu
  # When Admin verifies "<sideMenuElement>" options
  #Then "<sideMenuElement>" should be visible
  #Examples:
  #| Admin    | admin123 | Admin           |
  #| Admin    | admin123 | PIM             |
  #| Admin    | admin123 | Leave           |
  #| Admin    | admin123 | Time            |
  #| Admin    | admin123 | Recruitment     |
  #| Admin    | admin123 | My Info         |
  #| Admin    | admin123 | Performance     |
  #| Admin    | admin123 | Dashboard       |
  #| Admin    | admin123 | Directory       |
  #| Admin    | admin123 | Maintenance     |
  #| Admin    | admin123 | Claim           |
  #| Admin    | admin123 | Buzz            |
  @verifySideMenuPageTitle
  Scenario Outline: Check the page title of all side menu option upon click
    Given User logs into the admin account "Admin", "admin123" and lands on the dashboard page
    When Admin clicks on the "<SideMenuElements>"
    Then The page header should be "<pageHeader>"

    Examples: 
      | SideMenuElements | pageHeader  |
      | Admin            | Admin       |
      | PIM              | PIM         |
      | Leave            | Leave       |
      | Time             | Time        |
      | Recruitment      | Recruitment |
      | My Info          | PIM         |
      | Performance      | Performance |
      | Dashboard        | Dashboard   |
      | Directory        | Directory   |
      # | Maintenance      | Maintenance |
      | Claim            | Claim       |
      | Buzz             | Buzz        |

  @SearchSideMenuElement
  Scenario Outline: Serach for side menu option and verifies the option
    Given User logs into the admin account "Admin", "admin123" and lands on the dashboard page
    When Admin searches on the "<enterOption>"
    Then Search should show the following "<gotOption>"

    Examples: 
      | enterOption | gotOption   |
      | admin       | Admin       |
    #  | pim         | PIM         |
    #  | leave       | Leave       |
    #  | time        | Time        |
    #  | recruitment | Recruitment |
    #  | my Info     | PIM         |
    #  | performance | Performance |
    #  | dashboard   | Dashboard   |
    #  | directory   | Directory   |
      # | Maintenance      | Maintenance |
    #  | claim       | Claim       |
    #  | buzz        | Buzz        |
