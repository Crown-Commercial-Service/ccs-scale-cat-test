Feature: To verify Add Place API's

  @AddPlaceapiPOST
  Scenario Outline:Verify if Place is being Succesfully added using AddPlaceAPI "<scenarioID>"
    Given User has environment setup for <scenarioID>
    And "<API>" request payload is updated for "<method>"
    When user calls "<API>" with "<method>" http request
    Then API call should be success with "<statusCode>" for "<method>"
#    And "status" in response body is "OK"
#    And "scope" in response body is "APP"

    Examples:
      | scenarioID | API         | method | statusCode |
      | Scenario 1 | AddPlaceAPI | POST   | 200        |

  @GetPlaceapi
  Scenario Outline:Verify if Place is being Succesfully added using AddPlaceAPI "<scenarioID>"
    Given User has environment setup for <scenarioID>
    And "<API>" request payload is updated for "<method>"
    When user calls "<API>" with "<method>" http request
    Then API call should be success with "<statusCode>" for "<method>"
#    And "status" in response body is "OK"
#    And "scope" in response body is "APP"
    Examples:
      | scenarioID | API         | method | statusCode |
      | Scenario 2 | GetPlaceAPI | GET    | 200        |

  @DeletePlaceapi
  Scenario Outline:Verify if Place is being Succesfully added using AddPlaceAPI "<scenarioID>"
    Given User has environment setup for <scenarioID>
    And "<API>" request payload is updated for "<method>"
    When user calls "<API>" with "<method>" http request
    Then API call should be success with "<statusCode>" for "<method>"
    And "status" in response body is "OK"
#    And "scope" in response body is "APP"
    Examples:
      | scenarioID | API            | method | statusCode |
      | Scenario 3 | DeletePlaceAPI | DELETE | 200        |


  @testapi
  Scenario Outline: User Makes a Post request for <Scenario ID>
    Given User has environment setup for <Scenario ID>
    When POST request is updated for FTSE request
    And "POST" request is triggered for FTSE stocks
    Then User should get Expected results for FTSE
    Examples:
      | Scenario ID |
      | Company_001 |
