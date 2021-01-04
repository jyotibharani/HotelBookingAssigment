Feature: Hotel Booking Login

Scenario Outline: Unsucessfull Hotel Booking Login
 Given User is already on login Page
 And  Heading of login page is Hotel Booking Application
 When  user enter invalid credentails "<loginid>" and "<password>"
 Then user is on login page
 And close the browser
 
 

Examples:
 |loginid|password|
 |jyoti| |
 | |bharani|
 |jyoti|bharani|
  

Scenario: Sucessfull HotelBooking Login
Given User is already on login Page
 And  Heading of login page is Hotel Booking Application
 When  user enter valid login id and password
 And click on loginbtn
 Then Booking Details screen appear.
 And close the browser
 
 

 
 
 
 

