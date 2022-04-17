#SCAT-2305

Feature: POST request to create project

#SCAT-1850, SCC-740
  @Run
  Scenario Outline: Create a Project with the status as "Running" in Jaggaer
    Given an API endpoint to create new project
    When an user from an organisation requests new project using "<Payload>"
    Then a project should have been created in Jaggaer with the prescribed fields and status as Running
    And a valid response will be returned with the created project details
    Examples:
      |Payload|
      |TD001|

#SCC-741
  @Run
  Scenario Outline: Two Users from same Org creating project for same Agreement and Lot
    Given an API endpoint to create new project
    When an user from an organisation requests new project using "<Payload 1>"
    And another user from same organisation requests same project using "<Payload 2>"
    Then both projects should have been created with the same default name but with different procurement ID
    Examples:
      |Payload 1|Payload 2|
      |TD001    |TD002    |

#SCC-742
  @Run
  Scenario Outline: Two Users from different Org creating project for same Agreement and Lot
    Given an API endpoint to create new project
    When an user from an organisation requests new project using "<Payload 1>"
    And another user from different organisation requests same project using "<Payload 2>"
    Then both projects should have been created with different default name and procurement ID
    Examples:
      |Payload 1|Payload 2|
      |TD001    |TD003    |

#SCC-743
  @Run
  Scenario Outline: Created projects should have different default name and procurement ID
    Given an API endpoint to create new project
    When an user from an organisation requests new project using "<Payload 1>"
    And another user from same organisation requests new project using "<Payload 2>"
    Then both projects should have been created with different default name and procurement ID
    Examples:
      |Payload 1|Payload 2|
      |TD001    |TD004   |

#SCC-744
  @Run
  Scenario Outline: Created projects should be mapped in Tenders DB against Jaggaer Project Identifier
    Given an API endpoint to create new project
    When an user from an organisation requests new project using "<Payload>"
    Then Jaggaer Project Identifier is mapped to the procurement ID in Tenders DB
    Examples:
      |Payload|
      |TD001  |

#SCAT-2154
  @Run
  Scenario Outline: Rename an existing project
    Given an API endpoint to update project name
    When Buyer updates default project name with new "<Name>"
    Then the new project name should be updated in Jaggaer and Tenders DB table
    Examples:
      |Name|
      |TD001|