Feature: Set balance

Background:
    Given url baseUrl
    Given path '/balances'
    
Scenario: Adjust balance

    And header Accept = 'application/json'
    And request { id: 1, balance: 10.0}
    When method PUT
    Then status 200

Scenario: Get balance returns new balance

    When method GET
    Then status 200
    And match response == { id: 1, balance: 10.0 }

Scenario: Adjusting balance to negative returns an error

    And header Accept = 'application/json'
    And request { id: 1, balance: -10.0}
    When method PUT
    Then status 500

Scenario: Balance should not have changed

    When method GET
    Then status 200
    And match response == { id: 1, balance: 10.0 }