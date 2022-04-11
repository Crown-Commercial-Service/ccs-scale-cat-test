# Create Project in Jaggaer
# Validate Status as 200
# Validate name field
# Validate running status

#SCAT-2305
@Sprint7
Feature: POST request to create project

@Ignore
  Scenario: Create Project with a valid request
    When a POST request is sent to the Endpoint with a valid payload
    Then a project is created in Jaggaer and the details are returned in the response
    And validate project status in Jaggaer
    And Validate Project in CaT DB

#SCAT-1850, SCC-740
  @Run
  Scenario Outline:
    Given an API endpoint to create new project
    When an user from an organisation requests new project using "<Payload>"
    Then a project should have been created in Jaggaer with the prescribed fields and status as Running
    And a valid response will be returned with the created project details
    Examples:
      |Payload|
      |TD001|


#SCC-741
  @Run
    Scenario Outline:
    Given an API endpoint to create new project
    When an user from an organisation requests new project using "<Payload 1>"
    And another user from same organisation requests same project using "<Payload 2>"
    Then both projects should have been created with the same default name but with different procurement ID
    Examples:
      |Payload 1|Payload 2|
      |TD001    |TD002    |

#SCC-742
  @Run
  Scenario Outline:
    Given an API endpoint to create new project
    When an user from an organisation requests new project using "<Payload 1>"
    And another user from different organisation requests same project using "<Payload 2>"
    Then both projects should have been created with different default name and procurement ID
    Examples:
      |Payload 1|Payload 2|
      |TD001    |TD003    |

#SCC-743
  @Run
  Scenario Outline:
    Given an API endpoint to create new project
    When an user from an organisation requests new project using "<Payload 1>"
    And another user from same organisation requests new project using "<Payload 2>"
    Then both projects should have been created with different default name and procurement ID
    Examples:
      |Payload 1|Payload 2|
      |TD001    |TD004   |

#SCC-744
@Run
  Scenario Outline:
    Given an API endpoint to create new project
    When an user from an organisation requests new project using "<Payload>"
    Then Jaggaer Project Identifier is mapped to the procurement ID in Tenders DB
    Examples:
      |Payload|
      |TD001  |

#SCAT-2154
@Run
  Scenario Outline:
    Given an API endpoint to update project name
    When Buyer updates default project name with new "<Name>"
    Then the new project name should be updated in Jaggaer and Tenders DB table
    Examples:
      |Name|
      |TD001|