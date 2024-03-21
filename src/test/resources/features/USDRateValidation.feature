Feature: Validate USD exchange rate API responses

  The API at 'https://open.er-api.com/v6/latest/USD' should return valid and accurate exchange rate data for USD against multiple currencies, specifically focusing on the USD to AED rate.

  Scenario: Successful API call returns valid USD to AED rate
    Given I make a request to the USD exchange rate API with Serenity
    When I receive the response
    Then the status code should be 200
    And the response status should indicate success
    And the USD to AED rate should be between 3.6 and 3.7
    And the response should include a timestamp
    And the API response time should be less than 3 seconds
    And the response should contain 162 currency pairs

  Scenario: API returns a failure status
    Given I make a request to the USD exchange rate API with Serenity
    When I receive the response
    Then the response status should indicate failure
    And the error message should be descriptive

  Scenario: Validate JSON schema of the API response
    Given I make a request to the USD exchange rate API with Serenity
    When I receive the response
    Then the response should match the expected JSON schema