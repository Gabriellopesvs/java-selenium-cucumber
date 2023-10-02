Feature: Login

  @test
  Scenario: Successful login with valid credentials
    Given the website "https://the-internet.herokuapp.com/login" is accessed
    When the user logs in with the following credentials:
      | field    | value    |
      | name     | Richard  |
      | password | abcd1234 |
    Then the user should be logged in and see a success message
