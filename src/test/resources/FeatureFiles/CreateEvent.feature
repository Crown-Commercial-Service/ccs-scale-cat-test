# Create Project in Jaggaer
# Validate Status as 200
  # Validate name field
  # Validate running status

#@CaT
Feature: POST request to create event
  Scenario Outline: Create Event with a valid request
    Given a request is sent to the Create Event Endpoint for the <ProcID>
    Then the events are created and the details should be returned in the response
    And validate the details in Jaggaer
    Examples:
      |ProcID|
      |13    |
