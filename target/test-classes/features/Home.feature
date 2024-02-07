Feature: Home Page functionality
	As a User,
	I want to verify Home page links
	

Scenario: Verify 7 days trial link
 Given User is in the Home page
 When  User clicks on seven days trial button 
 Then  User should redirect to Register Page
 And   Signup Header text should displayed
 

Scenario: Verify explore location link
 Given User is in the Home page
 When  User clicks on explore all location
 Then  User should redirect to Browse Page
 And   Browse Header text should be displayed


Scenario: Verify footer Blogs link
 Given User is in the Home page
 When  User clicks on Blogs
 Then  User should redirect to Official Blog site
 And   Blog Logo should displayed in the page
 