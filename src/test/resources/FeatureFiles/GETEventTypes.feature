# GET event types
  # Status code and response validation

@CaT
Feature: GET request to retrieve event types
  Scenario: GET event types for a project
    When a GET request is sent to the endpoint
    Then all  possible event types are returned in the response

