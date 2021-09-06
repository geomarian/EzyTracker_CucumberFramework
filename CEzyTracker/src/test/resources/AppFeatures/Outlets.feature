Feature: Outlet Page Feature

Background:
Given user has logged in to application
|id|username|password|
|24sz-075o-21T6|dis1|12345|

@user
Scenario: Outlet page title
Given Outlet after Dashboard

Then AdminUser gets the title of the page
And webpage title should be "EZY | Dashboard"
When user clicks on Outlets
And Outlets title should be "EZY | Outlet List"
Then user clicks on Add New Outlet
And Outlets title should be a "EZY | Add Outlet"

Then Add Outlet name "Hutch"
Then Add contact number "7474747474"
Then Add Outlet address then add email "geo@mailinator.com"
And click on Cancel button
