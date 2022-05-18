#@CaT
Feature: Create 1FC Path C journey

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
    
    #<Procurement overview> Page <Step-2>
    Then Buyer navigates to "<Find suppliers and run your procurement online.>" page
    
    Examples: 
      | TestData |
      | TD001    |
