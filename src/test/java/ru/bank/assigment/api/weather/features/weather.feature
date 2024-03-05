
Feature: Get data of weather using Api

  Scenario Outline: Get weather for cities
    Given I have an API token
    When I request current weather for different <city>
    Then I should receive data of weather and successfull status code 200
    And I receive the response which contains different <city>
    Examples:
      | city    |
      | Minsk   |
      | Moscow  |
      | London |
      | Dubai   |


  Scenario: API 403 error handling
    Given I have an invalid API key
    When I request current weather for Minsk with invalid Token
    Then I should receive an error response code 403 with invalid Token

  Scenario: API 400 error handling
    Given I have a valid API key
    When I request current weather for incorrect city name
    Then I should receive an error response code 400

  Scenario: API 404 error handling
    When I request current weather in case incorrect URL
    Then I should receive an error response code 404

  Scenario: API 400 error handling in case without q parameter
    When I request current weather in case without q parameter
    Then I should receive an error response code 400 in case without q parameter