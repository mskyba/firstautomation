Feature: Log in

  As a non logger user
  I want to log in
  So I can use the internet
@SecondBefore
  Scenario: Valid login test
    Given user open the internet login page

    When user and enters 'tomsmith' in log in field and 'SuperSecretPassword!' in password
    And clicks 'Login' button
    Then user is logged in

    Scenario Outline: Negative login test
      Given user open the internet login page
      When user and enters '<login>' in log in field and '<password>' in password
      And clicks 'Login' button
      Then user sees error message 'qweqweqwe'

      Examples:
        | login   | password |
        | qweqwe  | qweqwe   |
        | qweqwe2 | qweqwe 1 |
        | qweqwe3 | qweqwe 2 |