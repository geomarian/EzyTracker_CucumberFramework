Feature: SKU Page Feature

Background:
Given user has logged into application
|id|username|password|
|24sz-075o-21T6|dis1|12345|

@SKU
Scenario: SKU page title
Given SKU after Dashboard
Then AdminUser gets the title of the page
And webpage title should be "EZY | Dashboard"
When user clicks on SKU
And SKU title should be "EZY | SKU List"
Then user clicks on Add New SKU
And SKU title should be a "EZY | Add SKU"
Then Add SKU Name "Thumbs Up"
Then Add Trade Rate "74"
Then Add SKU MRP "100"
And click on Cancel SKU