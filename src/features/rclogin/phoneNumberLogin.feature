@rcLogin
Feature: rcLogin

  Scenario: Login with valid phone number and password
    Given user has valid account
    When use login with "123456789" and "654321123"
    Then user can access RC home page

