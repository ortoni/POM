Feature: LeafTaps Automation
Scenario: Login
	And Enter username as DemoSalesManager 
	And Enter password as crmsfa 
	When Click login button 
	Then verify that login is succesful
	And Click logout
	
Scenario Outline: Login 2
	And Enter username as <username> 
	And Enter password as <password> 
	When Click login button 
	Then verify that login is succesful
#	And click logOut 
	Examples: 
		|username|password|
		|DemoSalesManager|crmsfa|
		|DemoCSR|crmsfa|
		
		
		
		
		
		
		
		
		
		
		
