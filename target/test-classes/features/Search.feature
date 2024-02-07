Feature: Search Functionality
		As an Anonynous and Logged-in user , 
	  I want to search news paper from home page
	  
Scenario Outline: Search Newspaper as Anonymous User with valid search criteria
	Given User is in the Home page
	When  User enters "<keyword>" , "<date>" and "<location>"
	And   User clicks search button
	Then  User redirect to Search Result Page
	And   Free Access button should be present in the page
	Examples:
	|keyword   |date      |location       |
	|test      |1980      |New York       |
	|test      |          |               |
	|          |1980      |               |
	|          |          |New York       |
	|test      |1980      |               |
	|test      |          |New York       |
	|          |1980      |New York       |
	
	
Scenario Outline: Search Newspaper as Anonymous User with blank search criteria
	Given User is in the Home page
	When  User enters "<keyword>" , "<date>" and "<location>"
	And   User clicks search button
	Then  User redirect to Search Result Page
	And   No Result Text should be displayed
		Examples:
	|keyword   |date      |location       |
	|          |          |               |

Scenario Outline: Search Newspaper as Loggedin User with valid search criteria
	Given User is in the Home page
	And   User is loggedin to the website
	When  User enters "<keyword>" , "<date>" and "<location>"
	And   User clicks search button
	Then  User redirect to Search Result Page
	And   Filters should be displayed in the page
	Examples:
	|keyword   |date      |location       |
	|test      |1980      |New York       |
	|test      |          |               |
	|          |1980      |               |
	|          |          |New York       |
	|test      |1980      |               |
	|test      |          |New York       |
	|          |1980      |New York       |
	
Scenario Outline: Search Newspaper as Loggedin User with blank search criteria
	Given User is in the Home page
	And   User is loggedin to the website
	When  User enters "<keyword>" , "<date>" and "<location>"
	And   User clicks search button
	Then  User redirect to Search Result Page
	And   No Result Text should be displayed
		Examples:
	|keyword   |date      |location       |
	|          |          |               |
	
	
#Scenario: Search Newspaper using audio 
	
	
	
	