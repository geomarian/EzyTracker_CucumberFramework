Feature: Outlet Page Feature

Background:
Given user has logged in to application
|id|username|password|
|24sz-075o-21T6|dis1|12345|

@user
Scenario: Outlet page title
Given Dashboard after login
Then AdminUser gets the title of the page
And webpage title should be "EZY | Dashboard"
And bottom line is "Copyright © 2021 Sales Person Tracking"