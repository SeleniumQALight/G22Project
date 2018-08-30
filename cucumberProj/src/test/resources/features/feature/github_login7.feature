Feature: github login

  @q
  Scenario: 71 login without username and password
    Given user is on github homepage
    When user clicks on Sign in button
    Then user is displayed login screen
