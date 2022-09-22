#@CaT
Feature: Create 1FC Path C journey

  
    #US-SCAT-4676 1FC Flow Sanity
    @UI
    Scenario Outline: 
    
  	#<Login> Page
  	Given Active or Registered buyer launches CAS application landing page of the "<TestData>"
  	Then Buyer navigates to "Sign in to the Public Procurement Gateway" page
  	When Buyer enters valid "<UserName>" and "<Password>" of the "<TestData>"
    And Buyer clicks on Sign In button
    
    #<Dashboard> Page
    Then Buyer navigates to "Find suppliers and run your procurement online." page
    #Then Buyer clicks on the event "ocds-b5fd17-6899" link
    And Buyer clicks on Accept all cookies button
    When Buyer clicks on "<Start a new Project>" link

    #<Choose a commercial agreement> Page
    Then Buyer navigates to "Choose a commercial agreement" page
    When Buyer selects the "<Lot1>" under commercial agreement "<Digital Specialists and Programmes (RM6263)>"

    #<Procurement overview> Page <Step-1>
    Then Buyer navigates to "Procurement overview" page
    #When Buyers clicks on "<Start pre-market engagement>" button under section "<2. Do pre-market engagement>"
    When Buyers clicks on "<Write and publish requirements>" button under section "<3. Write and publish your requirements>"

    #<Choose how to find a supplier> Page <Step-2>
    Then Buyer navigates to "Choose how to find a supplier" page
    And Buyer selects the "<Further competition>" radio button.
    And Buyer clicks on Save and continue button
        
   	 #<Write and publish your requirements> Page <Step-3>
     Then Buyer navigates to "Write and publish your requirements" page
    When Buyer clicks on "Choose the roles you need" page link.

    #<Choose the roles you need> Page <Step-34>
    Then Buyer navigates to "Choose the roles you need" page
    When Buyer enters the quantity for the roles
    And Buyer clicks on "Save and Continue" button

    #<Set your security and vetting requirements> Page <Step-35>
    Then Buyer navigates to "Set your security and vetting requirements" page
    When Buyer selects the security and vetting level
    And Buyer clicks on "Save and Continue" button

    #<Select essential skills and capabilities> Page <Step-36>
    Then Buyer navigates to "Select essential skills and capabilities" page
    When Buyer selects the skills and capabilities
    And Buyer clicks on "Save and Continue" button

    #<Where the work will be done?> Page <Step-37>
    Then Buyer navigates to "Where the work will be done?" page
    When Buyer selects the regions
    And Buyer clicks on "Save and Continue" button

    #<Write and publish your requirements> Page <Step-38>
    Then Buyer navigates to "Write and publish your requirements" page
    When Buyer clicks on "Set your assessment criteria and evaluation weightings" page link.

    #<Your assessment criteria> Page <Step-39>
    Then Buyer navigates to "Your assessment criteria" page
    When Buyer clicks on Add or Edit link for "Set the overall weighting between quality and price" page

    #<Set the overall weighting between quality and price> Page <Step-41>
    Then Buyer navigates to "Set the overall weighting between quality and price" page
    When Buyer enters quality and price weighting
    And Buyer clicks on "Save and Continue" button

    #<Set the weighting for the quality groups> Page <Step-42>
    Then Buyer navigates to "Set the weighting for the quality groups" page
    When Buyer enters weighting for quality
    And Buyer clicks on "Save and Continue" button

    #<Write your technical questions> Page <Step-43>
    Then Buyer navigates to "Write your technical questions" page
    When Buyer enters technical questions
    And Buyer clicks on "Save and Continue" button

    #<Write your cultural fit questions> Page <Step-44>
    Then Buyer navigates to "Write your cultural fit questions" page
    When Buyer enters cultural fit questions
    And Buyer clicks on "Save and Continue" button

    #<Write your social value questions> Page <Step-45>
    Then Buyer navigates to "Write your social value questions" page
    When Buyer enters social value questions
    And Buyer clicks on "Save and Continue" button

    #<Write and publish your requirements> Page <Step-47>
    Then Buyer navigates to "Write and publish your requirements" page
    When Buyer clicks on "How you will score suppliers" page link.

    #<How you will score suppliers> Page <Step-48>
    Then Buyer navigates to "How you will score suppliers" page
    When Buyer enters scoring criteria
    And Buyer clicks on "Save and Continue" button

     #<Write and publish your requirements> Page <Step-49>
    Then Buyer navigates to "Write and publish your requirements" page
    When Buyer clicks on "See the available suppliers" page link.

    #<See the available suppliers> Page <Step-50>
    Then Buyer navigates to "See the available suppliers" page
    And Buyer clicks on "Save and Continue" button

    #<Your timeline> Page <Step-52>
    Then Buyer navigates to "Your timeline" page
    And Buyer clicks on "Save and Continue" button

    #<Review and publish> Page <Step-53>
    Then Buyer navigates to "Review and publish" page
    And Buyer selects the checkbox
    When Buyer clicks "Publish and continue" button

    #<Your further competition has been published> Page <Step-54>
    Then Buyer navigates to "Your further competition has been published" page
    When Buyer clicks on the "Go to Dashboard" button

    #<Find suppliers and run your procurement online> Page
    Then Buyer navigates to "Find suppliers and run your procurement online." page
    And Buyer validates the published event

    Examples:
      | TestData|
      | TD002   |
