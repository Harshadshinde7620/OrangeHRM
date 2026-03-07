Feature: Dashboard side menu validations

  @sideMenuVisibility
  Scenario Outline: Check visibility of all elements in the side menu
    Given Admin login into the portal using "Admin" , "admin123" and gets to dashboard
    When Admin verifies "<sideMenuElement>" options
    Then "<sideMenuElement>" should be visible

    Examples: 
      | sideMenuElement |
      | Admin           |
      | PIM             |
      | Leave           |
      | Time            |
      | Recruitment     |
      | My Info         |
      | Performance     |
      | Dashboard       |
      | Directory       |
      | Maintenance     |
      | Claim           |
      | Buzz            |

  @verifySideMenuPageTitle
  Scenario Outline: Check the page title of all side menu option upon click
    Given Admin login into the portal using "Admin" , "admin123" and gets to dashboard
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
    Given Admin login into the portal using "Admin" , "admin123" and gets to dashboard
    When Admin search on the "<enterOption>"
    Then Search should show the following "<gotOption>"

    @FullSearchText
    Examples: 
      #| enterOption | gotOption   |
      #| admin       | Admin       |
      #| pim         | PIM         |
      #| leave       | Leave       |
      #| time        | Time        |
      #| recruitment | Recruitment |
      #| my Info     | My Info     |
      #| performance | Performance |
      #| dashboard   | Dashboard   |
      #| directory   | Directory   |
      #| maintenance | Maintenance |
      #| claim       | Claim       |
      #| buzz        | Buzz        |

    @PartialSearchText
    Examples: 
      #| enterOption | gotOption   |
      #| ad          | Admin       |
      #| pi          | PIM         |
      #| lea         | Leave       |
      #| ime         | Time        |
      #| ment        | Recruitment |
      
    @InsensitiveSearchText
    Examples: 
      | enterOption | gotOption   |
      | adMIn       | Admin       |
      | pIm         | PIM         |
      | LeaVE       | Leave       |
      | tIME        | Time        |
      | reCRuiTMent | Recruitment |
      
   @BlankSearchText
  	Scenario Outline: Blank search for side menu option and verifies the option
    Given Admin login into the portal using "Admin" , "admin123" and gets to dashboard
    When Admin blank search on the "<enterOption>"
    Then Search should show "<list>" of the options 
    Examples: 
      #| enterOption | list   |
      #|           	|   Admin, PIM, Leave, Time, Recruitment, My Info, Performance, Dashboard, Directory, Maintenance, Claim, Buzz     			|
      
      
      
