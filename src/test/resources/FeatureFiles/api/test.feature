Feature: To verify Add Place API's

  @AddPlaceapiPOST
  Scenario Outline:Verify if Place is being Succesfully added using AddPlaceAPI "<scenarioID>"
    Given User has environment setup for <scenarioID>
    And Add Place Payload request is updated
    When user calls addPlaceAPI with "<method>" http request
    Then API call should be success with "<statusCode>"
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      | scenarioID | method | statusCode |
      | Scenario 1 | POST   | 200        |

  @AddPlaceapiGET
  Scenario Outline:Verify if Place is being Succesfully added using AddPlaceAPI "<scenarioID>"
    Given User has environment setup for <scenarioID>
    And Add Place Payload request is updated
    When user calls addPlaceAPI with "<method>" http request
    Then API call should be success with "<statusCode>"
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      | scenarioID | method | statusCode |
      | Scenario 2 | GET    | 200        |


  Scenario Outline: User Makes a Post request for <Scenario ID>
    Given User has environment setup for <Scenario ID>
    When POST request is updated for FTSE request
    And POST request is triggered for FTSE stocks
    Then User should get Expected results for FTSE
    Examples:
      | Scenario ID |
      | Company_001 |
