Feature: API Testing 

  Scenario Outline: As a user I want to get a single user and verify the response code is 200
    Given User set GET reqres in api endpoint
    And Send GET HTTP request
    Then User receive valid HTTP response code 200
