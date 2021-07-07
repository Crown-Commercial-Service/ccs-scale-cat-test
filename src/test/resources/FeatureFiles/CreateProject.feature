Feature: POST request to create project
  Scenario: Create Project with a valid request
    Given an Endpoint to create a project from agreement
    When a request is sent to the Endpoint valid payload
    Then the created project details should be displayed in the response
