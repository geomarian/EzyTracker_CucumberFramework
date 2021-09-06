Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "EZY | Login"


Scenario: Login with correct credentials
Given user is on login page
When user enters id "24sz-075o-21T6"
And user enters username "dis1"
And user enters password "12345"
And user clicks on Login button
Then user gets the title of the page
And page title should be "EZY | Dashboard"

