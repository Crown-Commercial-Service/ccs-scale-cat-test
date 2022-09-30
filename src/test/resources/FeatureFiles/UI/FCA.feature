Feature: Create a Further competition with Capability Assessment (FCA) event

    #US-SCAT-5181 FCA flow
    @FCA
    Scenario Outline: 
    
  	#<Login> Page
  	Given Active or Registered buyer launches CAS application landing page of the "<TestData>"
  	Then Buyer navigates to "Sign in to the Public Procurement Gateway" page
  	When Buyer enters valid "<UserName>" and "<Password>" of the "<TestData>"
    And Buyer clicks on Sign In button
    
    #<Dashboard> Page
    Then Buyer navigates to "Find suppliers and run your procurement online." page
    #Then Buyer clicks on the event "ocds-pfhb7i-8510" link
    And Buyer clicks on Accept all cookies button
    When Buyer clicks on "<Start a new Project>" link

    #<Choose a commercial agreement> Page
    Then Buyer navigates to "Choose a commercial agreement" page
    When Buyer selects the "<Lot1>" under commercial agreement "<Digital Specialists and Programmes (RM6263)>"

    #<Procurement overview> Page <Step-1>
    Then Buyer navigates to "Procurement overview" page
    When Buyers clicks on "<Write and publish requirements>" button under section "<3. Write and publish your requirements>"

    #<Choose how to find a supplier> Page <Step-2>
    Then Buyer navigates to "Choose how to find a supplier" page
    And Buyer selects the "<Further competition>" radio button.
    And Buyer clicks on "Save and continue" button

    #<What is a capability assessment?> Page <Step>
    Then Buyer navigates to "What is a capability assessment?" page
    When Buyer clicks on "continue" button

    #<Choose how to build your bid pack> Page <Step>
    Then Buyer navigates to "Choose how to build your bid pack" page
    When Buyer selects how to build the bid pack
    And Buyer clicks on "Save and continue" button
        
   	 #<Write and publish your requirements> Page <Step-3>
    Then Buyer navigates to "Write and publish your requirements" page
    When Buyer clicks on "Enter your weightings" page link.

    #<Enter your weightings> Page <Step-10>
    Then Buyer navigates to "Enter your weightings" page
    When Buyer enters the dimension weightings
    And Buyer clicks on "Save and continue" button

    #<Use of subcontractors> Page <Step-11>
    Then Buyer navigates to "Use of subcontractors" page
    When Buyer selects a subcontractors option
    And Buyer clicks on "Save and continue" button

    #<Select resources and set weightings> Page <Step-12>
    Then Buyer navigates to "Select resources and set weightings" page
    When Buyer selects resources and set weightings
    And Buyer clicks on "Save and continue" button

    #<Choose your highest security and vetting requirements> <Step-13>
    Then Buyer navigates to "Choose your highest security and vetting requirements" page
    When Buyer selects the security and vetting requirements
    And Buyer clicks on "Save and continue" button

    #<Select service capabilities> <Step-15>
    Then Buyer navigates to "Select service capabilities" page
    When Buyer selects service capabilities
    And Buyer clicks on "Save and continue" button

    #<How much the team can grow (scale)> <Step-16>
    Then Buyer navigates to "How much the team can grow (scale)" page
    When Buyer selects a growth range
    And Buyer clicks on "Save and continue" button

    #<Where the work will be done> Page <Step-17>
    Then Buyer navigates to "Where the work will be done" page
    When Buyer selects the regions for Capability Assessment
    And Buyer clicks on "Save and continue" button

    #<Number of suppliers to take to further competition> Page <Step-18>
    Then Buyer navigates to "Number of suppliers to take to further competition" page
    When Buyer enters number of suppliers
    And Buyer clicks on "Save and continue" button

    #<Review suitable suppliers> Page <Step-19>
    Then Buyer navigates to "Review suitable suppliers" page
    And Buyer selects the suppliers
    And Buyer clicks on "Save and continue" button

    #<Choose your Next Steps> Page <Step-21>
    Then Buyer navigates to "Choose your Next Steps" page
    And Buyer selects the Next Steps
    And Buyer clicks on "Save and continue" button

    #<Write and publish your requirements> Page
    Then Buyer navigates to "Write and publish your requirements" page

    Examples:
      | TestData|
      | TD003   |
