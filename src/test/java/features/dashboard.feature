Feature: Dashboard functionality

  #@TimeAtWorkWidgetVisibility
  #Scenario: Verify Time at Work widget is visible on dashboard
  # Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
  # And Admin navigates to the dashboard page
  #Then "Time at Work" widget should be visible
  # @TimeAtWorkWidgetStopWatchPage
  # Scenario: Verify Attendance page is opened on click of stopwatch
  #  Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
  #   And Admin navigates to the dashboard page
  #   Then Admin clicks on the stopwatch and gets to Attendance page.
  @MyActionsWidgetVisibility
  Scenario: Verify My Actions widget is visible on dashboard
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    And Admin navigates to the dashboard page
    Then "My Actions" widget must be visible

  @MyActionsWidgetLink1Page
  Scenario Outline: Verify My Actions widget is visible on dashboard
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    And Admin navigates to the dashboard page
    Then Admin verfies the page title to be Performance page upon click of link1

  #QuickLaunchWidget
  @QuickLaunchWidgetVisibility
  Scenario: Verify Quick Launch widget is visible on dashboard
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    And Admin navigates to the dashboard page
    Then "Quick Launch" widget is visible

  @QuickLaunchWidgetClickableLinks
  Scenario Outline: Verify the page title of on clicks of clikable links
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    And Admin navigates to the dashboard page
    Then Admin verfies "<links>" and its "<pageTitles>" of the widget

    Examples: 
      | links        | pageTitles |
      | Assign Leave | Leave      |
      | Leave List   | Leave      |
      | Timesheets   | Time       |
      | Apply Leave  | Leave      |
      | My Leave     | Leave      |
      | My Timesheet | Time       |

  #BuzzLatestPostWidget
  @BuzzLatestPostWidgetVisibility
  Scenario: Verify Buzz Latest Posts widget is visible on dashboard
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    And Admin navigates to the dashboard page
    Then Verify visibility of "Buzz Latest Posts" widget

  @BuzzLatestPostWidgetClickableLinks
  Scenario: Verify number of clickable links in Buzz Latest Posts widget
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    And Admin navigates to the dashboard page
    Then Verify number of clickable links in "Buzz Latest Posts" widget is 5

  @BuzzLatestPostWidgetClickableLinksAlongWithUsernames
  Scenario Outline: Verify clickable usernames in Buzz Latest Posts widget
    Given Admin logs into the OrangeHRM portal using "Admin" , "admin123"
    And Admin navigates to the dashboard page
    Then Verify "<userNames>" is present as clickable user in Buzz Latest Posts widget

    Examples: 
      | userNames                 |
      | Ibrahim Mohammed Khamiss |
      | Ibrahim Mohammed Khamiss |
      #| Sania  Shaheen            |
      #| Rebecca  Harmony          |
      #| Russel  Hamilton          |
