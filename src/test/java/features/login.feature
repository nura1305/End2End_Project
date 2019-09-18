Feature: Login into website

Scenario Outline: Non-registered user
Given Initialize browser with chrome
And Navigate to "http://qaclickacademy.com" website
And Click on Login button on Homepage to land on Secure SignIn page
When user enters <username> and <password> and logs in
Then Verify that user has successfully loged in
And Close browsers

Examples:
|username	       |password	|
|test99@gmail.com  |123456	    |

Scenario: Navigation Bar is validated
Given Initialize browser with chrome
When Navigate to "http://qaclickacademy.com" website
Then Verify that Navigation bar is displayed
And Close browsers

Scenario: Validate Title
Given Initialize browser with chrome
When Navigate to "http://qaclickacademy.com" website
Then Verify that page title is displayed
And Close browsers
