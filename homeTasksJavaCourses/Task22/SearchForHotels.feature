Feature: Test search for hotels 

Scenario Outline: Check that search returns results 
	Given I am on main page 
	When I type "<city>" in search field 
	And I select "<number>" of adults 
	And I click Search button 
	Then I see hotels in search results 
	Examples: 
		|city|number1|number2|
		|Moscow|3|1|
		|Moscow|4|2|
		
