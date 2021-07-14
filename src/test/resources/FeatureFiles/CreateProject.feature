# Create Project in Jaggaer
# Validate Status as 200
# Validate name field
# Validate running status

@CaT
Feature: POST request to create project
  Scenario: Create Project with a valid request
    When a POST request is sent to the Endpoint with a valid payload
    Then a project is created in Jaggaer and the details are returned in the response
    And validate project status in Jaggaer