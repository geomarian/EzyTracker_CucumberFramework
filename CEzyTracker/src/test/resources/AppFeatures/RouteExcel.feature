Feature: Adding data from Excel to Route

Background:
Given user has logged into application
|id|username|password|
|24sz-075o-21T6|dis1|12345|

Scenario Outline: Data will be added from excel
Given user has logged application

When user clicks on Get Routes button
Then user clicks on Add button 
Then User fills the data from given sheetName "<SheetName>" and rowNumber <RowNumber>
Then it shows successful message "Route details added successfully"

Examples:
|SheetName|RowNumber|
|Sheet1|0|
|Sheet1|1|