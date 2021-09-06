Feature: User Page Feature

Background:
Given user has already logged in to application
|id|username|password|
|24sz-075o-21T6|dis1|12345|

@user
Scenario: User page title
Given user is from Dashboard

Then AdminUser gets the title of the page
And webpage title should be "EZY | Dashboard"
When user clicks on Users
And Userpage title should be "EZY | User List"
Then click on refresh button
Then user clicks on New user
And click on cancel button from add user