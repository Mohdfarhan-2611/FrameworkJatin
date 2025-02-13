Feature: PIM Module Functionality

#  As a user of the OrangeHRM website
#  I want to be able to log in with my account
#  So that I can access my account-related features
#
#  Background:
#  Given I am on the opencart login page


  Scenario: verify user is able to click on EmployeeList header
    Given Launch the browser
    When Login with valid email and valid password "Email" and "Password"
    Then Click on EmployeeList Header
    And Close the browser






  Scenario: verify user is able to scroll to the bottom till the carousel
    Given Launch the browser
    When Login with valid email and valid password "Email" and "Password"
    Then Click on EmployeeList Header
    Then Scroll to the second carausel
    And Close the browser







