#@CaT
Feature: Create 1FC Path C journey

  
    #US-SCAT-4676 1FC Flow Sanaity
    @1FC-Flow
    Scenario Outline: 
    
  	#<Login> Page
  	Given Active or Registered buyer launches CAS application landing page of the "<TestData>"
  	Then Buyer navigates to "<Sign in to the Public Procurement Gateway>" page
  	When Buyer enters valid "<UserName>" and "<Password>" of the "<TestData>"
    And Buyer clicks on Sign In button
    
    #<Dashboard> Page
    Then Buyer navigates to "<Find suppliers and run your procurement online>" page
    And Buyer clicks on Accept all cookies button
    When Buyer clicks on "<Start a new Project>" link
    
    #<Choose a commercial agreement> Page
    Then Buyer navigates to "<Choose a commercial agreement>" page
    When Buyer selects the "<Lot1>" under commercial agreement "<Digital Specialists and Programmes (RM6263)>"
    
    #<Procurement overview> Page <Step-1>
    Then Buyer navigates to "<Procurement overview>" page
    #When Buyers clicks on "<Start pre-market engagement>" button under section "<2. Do pre-market engagement>"
    When Buyers clicks on "<Write and publish requirements>" button under section "<3. Write and publish your requirements>"
        
    #<Choose how to find a supplier> Page <Step-2>
    Then Buyer navigates to "<Choose how to find a supplier>" page
    And Buyer selects the "<Further competition>" radio button.
    And Buyer clicks on Save and continue button
        
   	#<Write and publish your requirements> Page <Step-3>
    Then Buyer navigates to "<Write and publish your requirements>" page
    
   	
    Examples: 
      | TestData |
      | TD001   |
      







  #SCAT-4676
  @RFI-Flow
  Scenario Outline: 
  	#<Login> Page
  	
  	Given Active or Registered buyer launches CAS application landing page
    When Buyer enters valid "<UserName>" and "<Password>" of the "<TestData>"
    And Buyer clicks on Sign In button
    
    #<Dashboard> Page
    Then Buyer navigates to "<Find suppliers and run your procurement online>" page
    And Buyer validates "<Find suppliers and run your procurement online>" page "<Header>" "<Banner>" "<HelpSection>" & "<Footer>" is as per figma.   
    When Buyer clicks on "<Start a new Project>" link
    
    #<Choose a commercial agreement> Page
    Then Buyer navigates to "<Choose a commercial agreement>" page
    And Buyer validates "<Choose a commercial agreement>" page "<Header>" "<Banner>" "<HelpSection>" & "<Footer>" is as per figma.
    When Buyer selects the "<Lot1>" under commercial agreement "<Digital Specialists and Programmes (RM6263)>"
    
    #<Procurement overview> Page <Step-1>
    Then Buyer navigates to "<Procurement overview>" page
    And Buyer validates "<Procurement overview>" page "<Header>" "<Banner>" "<HelpSection>" & "<Footer>" is as per figma.
    And Buyer validates "<Procurement overview>" page "<AgreementDetails>" & "<RelatedContent>" is as per figma.
    And Buyer validates the page content
    When Buyers clicks on "<Start pre-market engagement>" button under section "<2. Do pre-market engagement>"
    
    #<Do pre-market engagement> Page <Step-2>
    Then Buyer navigates to "<Do pre-market engagement>" page
    And Buyer validates "<Procurement overview>" page "<Header>" "<Banner>" "<HelpSection>" & "<Footer>" is as per figma.
    And Buyer validates "<Procurement overview>" page "<AgreementDetails>" & "<RelatedContent>" is as per figma.
   	And Buyer validates the Do pre-market engagement page content
    When Buyers clicks on "<Name your project>" link.
        
    #<Name your project> Page <Step-3>
    #Then Buyer navigates to "<Name your project>" page
    And Buyer validates "<Procurement overview>" page "<Header>" "<Banner>" "<HelpSection>" & "<Footer>" is as per figma.
    And Buyer validates "<Procurement overview>" page "<AgreementDetails>" & "<RelatedContent>" is as per figma.
   	
    Examples: 
      | TestData |
      | TD001    |
      
      
   
  
      
      
