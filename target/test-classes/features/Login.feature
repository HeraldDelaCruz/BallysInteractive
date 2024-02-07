Feature: Login page functionality
	As a user, 
	I want to Login to the site using valid and invalid credentials
	
	
Scenario Outline: Login with valid credentials
	Given User is in the website Landing page
	When  User navigates the Login page
	And   User enters "<email address>" in email field and "<password>" in password field
	And   User clicks on Login button
	Then  User should redirect to Home page with users logged-in named "<users name>"
	Examples:
	|email address  	      |password    |users name     |
	|lourdes100@test.com    |Test123!    |lourdestest    |
	
	
Scenario Outline: Login with invalid credentials
	Given User is in the website Landing page
	When  User navigates the Login page
	And   User enters "<email address>" in email field and "<password>" in password field
	And   User clicks on Login button
	Then  An error prompt appear with "<negative scenario>"
	Examples:
	|email address 	            |password        |negative scenario                   |
	|IncorrectEmail@test.com    |Test123!        |invalid email and valid password    |
	|lourdes100@test.com        |IncorrectPass   |valid email and invalid password    |
	|IncorrectEmail@test.com    |IncorrectPass   |invalid email and invalid password  |
	
	
Scenario Outline: Login with blank credentials
	Given User is in the website Landing page
	When  User navigates the Login page
	And   User enters "<email address>" in email field and "<password>" in password field
	Then  Login button should be disabled
  Examples:
	|email address 	       |password     |
	|lourdes100@test.com	 |             |
	|                      |Test123!     |
	|                      |             |

	
	
	
	