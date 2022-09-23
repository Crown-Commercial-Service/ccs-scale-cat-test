#@CaT
Feature: Create 1FC Path C journey

  
    #US-SCAT-4676 1FC Flow Sanaity
    @1FC-Flow
    Scenario Outline: 
    
  	#<Login> Page
  	Given Active or Registered buyer launches CAS application landing page of the "<TestData>"
  	Then Buyer navigates to "Sign in to the Public Procurement Gateway" page
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
    And Buyer clicks on link "<Upload your pricing schedule>" under section2
    
    #<2. Upload pricing schedules and other documents> Page <Step-4>
    Then Buyer navigates to "<2. Upload pricing schedules and other documents>" page
    And Buyer clicks on link "<Add or change upload>" in page "<Upload pricing schedules and other documents>"
        
    #<Upload your pricing schedule> Page <Step-5>
    Then Buyer navigates to "<Upload your pricing schedule>" page
    And Buyer selects the document in page Upload your pricing schedule
    And Buyer clicks on upload button in page Upload your pricing schedule
    And Buyer selects the I confirm checkbox
    And Buyer clicks on Save and continue button
    
    
    #<Upload your terms and conditions and other documents> Page <Step-6>
    Then Buyer navigates to "<Upload your terms and conditions and other documents>" page
    And Buyer selects the document in page Upload your terms and conditions and other documents
    And Buyer clicks on upload button in page Upload your terms and conditions and other documents
    And Buyer clicks on Save and continue button
    
    #<Write and publish your requirements> Page <Step-6a>
    Then Buyer navigates to "<Write and publish your requirements>" page
    And Buyer clicks on link "<Confirm if you need a contracted out service or supply of resource.>" under section2
    
    #<Confirm if you need a contracted out service or supply of resource> Page <Step-7>
    Then Buyer navigates to "<Confirm if you need a contracted out service or supply of resource>" page
    And Buyer selects one of the option by selecting the radio button
    And Buyer clicks on Save and continue button
    
    #<Write and publish your requirements> Page <Step-8>
    Then Buyer navigates to "<Write and publish your requirements>" page
    And Buyer clicks on link "<Add context and requirements>" under section3 Add context to your further competition
    
    #<About adding context and requirements> Page <Step-9>
    Then Buyer navigates to "<Add context and requirements>" page
    And Buyer clicks on link "<About adding context and requirements>"
    
    #<About adding context and requirements> Page <Step-10>
    Then Buyer navigates to "<About adding context and requirements>" page
    And Buyer clicks on Continue button
    
    # Defect page SCAT-5966
   	#<Confirm if you need a contracted out service or supply of resource> Page <Step-7>
    #Then Buyer navigates to "<Confirm if you need a contracted out service or supply of resource>" page
    #And Buyer clicks on Save and continue button
    
    #<Terms and acronyms (Optional)> Page <Step-10>
    Then Buyer navigates to "<Terms and acronyms (Optional)>" page
    And Buyer clicks on Save and continue button
    
    #<Add background to your procurement> Page <Step-11>
    Then Buyer navigates to "<Add background to your procurement>" page
    And Buyer enters the value in "<background information>" and "<Social economic & environmental benefits>" text box.
    And Buyer clicks on Save and continue button
    
    #<The business problem you need to solve> Page <Step-12>
    #Then Buyer navigates to "<The business problem you need to solve>" page
    And Buyer enters the value in text box The business problem you need to solve.
    And Buyer clicks on Save and continue button
    
    #<The people who will use your product or service (Optional)> Page <Step-13>
    #Then Buyer navigates to "<The people who will use your product or service (Optional)>" page
    And Buyer clicks on Save and continue button
  
    #<Work done so far (optional)> Page <Step-14>
    #Then Buyer navigates to "<Work done so far (optional)>" page
    And Buyer clicks on Save and continue button
    
    #<Which phase the project is in> Page <Step-15>
    #Then Buyer navigates to "<Which phase the project is in>" page
    And Buyer selects the "<Discovery>" radio button in Which phase the project is in page.
    And Buyer clicks on Save and continue button
    
    #<Which phases of the project you need resource for> Page <Step-16>
    #Then Buyer navigates to "<Which phases of the project you need resource for>" page
    And Buyer selects the check box in Which phases of the project you need resource for page.
    And Buyer clicks on Save and continue button
        
    #<How long the project will last> Page <Step-17>
    #Then Buyer navigates to "<How long the project will last>" page
    And Buyer enters the dates
    And Buyer clicks on Save and continue button
    
    #<The organisation the product or service is for (Optional)> Page <Step-18>
    #Then Buyer navigates to "<The organisation the product or service is for (Optional)>" page
    And Buyer clicks on Save and continue button
    
    #<Describe any pre-market engagement you've done (Optional)> Page <Step-19>
    #Then Buyer navigates to "<Describe any pre-market engagement you've done (Optional)>" page
    And Buyer clicks on Save and continue button
    
    #<Choose if this is new, replacement or expanded product or service> Page <Step-20>
    #Then Buyer navigates to "<Choose if this is new, replacement or expanded product or service>" page
    And Buyer selects one of the option by selecting the radio button in Choose if this is new, replacement or expanded product or service page
    And Buyer clicks on Save and continue button
    
    #<Tell us if there is an existing supplier> Page <Step-21>
    #Then Buyer navigates to "<Tell us if there is an existing supplier>" page
    And Buyer selects one of the option by selecting the radio button in Tell us if there is an existing supplier page
    And Buyer clicks on Save and continue button
    
    #<Management information and reporting requirements> Page <Step-22>
    #Then Buyer navigates to "<Management information and reporting requirements>" page
    And Buyer enters the value in text box Specify what you expect from MI submissions.
    And Buyer clicks on Save and continue button
    
    #<Add your service levels and KPIs> Page <Step-23>
    #Then Buyer navigates to "<Add your service levels and KPIs>" page
    And Buyer enters the value in text boxs for service level requirement or KPI
    And Buyer clicks on Save and continue button
    
    #<Add any performance incentives and exit strategies> Page <Step-24>
    #Then Buyer navigates to "<Add your service levels and KPIs>" page
    And Buyer enters the value in text boxs performance incentives and exit strategy
    And Buyer clicks on Save and continue button
    
    #<State your total contract value, including any extensions (optional)> Page <Step-25>
    #Then Buyer navigates to "<State your total contract value, including any extensions (optional)>" page
    And Buyer clicks on Save and continue button
    
    #<Enter your project requirements> Page <Step-26>
    #Then Buyer navigates to "<Enter your project requirements>" page
    And Buyer enters the value in text boxs Name of the group and requirement and Describe the requirement
    And Buyer clicks on Save and continue button
       
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
      
      
   
  
      
      
