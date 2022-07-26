Feature: Amazon first page
 Scenario Outline: Verify About this item section is present
 Given User navigate to desired product
 And Application opens the main page
 And User click on hamburger menu
 And User goes to shop by department and selects the "<feature>" under it
 And User selects the subtopic
 And User filters the results
 And User sorts the results according to price
 And User selects the second highest priced item
 When Application switch to Window
 Then User assert about this item section

    Examples:
      |feature                     |
      |TV, Appliances, Electronic  |



