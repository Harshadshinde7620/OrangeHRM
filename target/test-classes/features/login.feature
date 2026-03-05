Feature: Admin login page

  @sucessfullLogin
  Scenario Outline: Admin should be able to login with valid credentails
    Given Admin is on the webpage
    When He enters "<username>", "<password>" and clicks on login button
    Then Admin is redirected to dashboard page.

    Examples: 
      | username | password |
      | Admin    | admin123 |

  @invlaidLogin @Regression @Smoke @sanity
  Scenario Outline: Admin should not be able to login with invalid credentails
    Given Admin is on the webpage
    When He enters "<username>", "<password>" and clicks on login button
    Then Admin see "<errorMessages>"

    Examples: 
      | username | password     | errorMessages       |
      | harshad  | admin123     | Invalid credentials |
      | Admin    | harshad@1234 | Invalid credentials |
      | harshad  | harshad@1234 | Invalid credentials |
      
      
      @EdgeCases
      Examples: 
      | username | password     | errorMessages       |
      |          |              | Required            |
      
      
