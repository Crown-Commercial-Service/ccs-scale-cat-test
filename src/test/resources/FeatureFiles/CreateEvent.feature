Feature: Retrieve,Create and Update an event

  #@CaS
  Scenario Outline: Create an event with a valid request
    Given an API endpoint to create a new event
    When a "<Buyer>" sends a request to create an event with type "<event-type>" and title "<title>" for <ProcID>
    Then an event should be created and the "<title>" should be returned in the response
    And validate the details in Jaggaer
    And validate the event details in the DB
    Examples:
      |ProcID|event-type|Buyer|title|
      |3963  |RFI       |data1|3963-RFI|

  #@CaS
  Scenario Outline: Update an event with a valid request
    Given an API endpoint to update an existing event
    And "<Buyer>" has created a project for "<Agreement>" and "<Lot>" with a default event
    When a "<Buyer>" sends a request to update the event with type "<Event-type>" and title "<title>"
    Then an event should be created and the "<title>" should be returned in the response
    And validate the details in Jaggaer
    And validate the event details in the DB
    Examples:
      |Agreement|Lot|Buyer|Event-type|title|
      |RM6263   |Lot 1|data1|RFI     |RFI Event 001|

  @CaS
  Scenario Outline: Retrieve valid event types for a project
    Given an API endpoint to retrieve valid event types for a project
    And "<Buyer>" has created a project for "<Agreement>" and "<Lot>" with a default event
    When a "<Buyer>" sends a request to retrieve valid events for project
    Then the "<Event-types>" should be returned in the response
    Examples:
      |Agreement|Lot|Buyer|Event-types|
      |RM6263   |Lot 1|data1|RFI,FCA,FC|
      |RM6263   |Lot 2|data1|RFI,FCA,DAA,DA,FC|
      |RM6187   |Lot 2|data1|RFI,EOI,DA,FC|