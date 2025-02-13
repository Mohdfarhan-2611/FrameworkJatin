Feature: Login functionality

  As a user of the OrangeHRM website
  I want to be able to log in with my account
  So that I can access my account-related features
#
#  Background:
#  Given I am on the opencart login page


  Scenario: Successful login with valid credentials
    Given Launch the browser
    When  Login webapplication with "email" and "pass"
    Then Verify the PIM text on the logged in page
    And Close the browser




  Scenario: Unsuccessful login with invalid or empty credentials
    Given Launch the browser
    When  I login with Invalid user details using LoginUser object
    Then Verify the Error Message
    And Close the browser


