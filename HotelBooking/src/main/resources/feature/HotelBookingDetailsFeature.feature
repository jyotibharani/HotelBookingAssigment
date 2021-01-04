Feature: Hotel Booking Details

Scenario: Sucessfull Booking
Given User is already on login Page
 And  Heading of login page is Hotel Booking Application
 When  user enter valid login id and password
 And click on loginbtn
 Then Booking Details screen appear.
 When  user enter proper details .
 Then Booking Sucessfull page appears. 
 And close the browser
    
 
Scenario Outline: Unsucessfull Booking 
 Given User is already on login Page
 And  Heading of login page is Hotel Booking Application
 When  user enter valid login id and password
 And click on loginbtn
 Then Booking Details screen appear.
 When  user doesnot enter proper details "<FN>" and "<LN>" and "<emailid>" and "<contactnumber>" and "<address>"and "<city>" and "<state>" and "<guestcount>" and "<cardholdername>" and "<cardholdernumber>" and "<cvv>" and "<expirymonth>" and "<expiryyear>"
 Then  user is on Booking details screen.
 And close the browser

Examples:
|FN|LN|emailid|contactnumber|address|city|state|guestcount|cardholdername|cardholdernumber|cvv|expiryyear|expirymonth|
||bharani|testemail@nomail.com|9632144098|test|Pune|Maharashtra|2|jyoti|56565656565656|111|2021|05|
|jyoti||testemail@nomail.com|9632144098|test|Pune|Maharashtra|2|jyoti|56565656565656|111|2021|05|
|jyoti|bharani||9632144098|test|Pune|Maharashtra|2|jyoti|56565656565656|111|2021|05|
|jyoti|bharani|jyotibharani|9632144098|test|Pune|Maharashtra|2|jyoti|56565656565656|111|2021|05|
|jyoti|bharani|jyotibharani1@gmail.com|5632144098|test|Pune|Maharashtra|2|jyoti|56565656565656|111|2021|05|
|jyoti|bharani|jyotibharan1i@gmail.com|963214409|test|Pune|Maharashtra|2|jyoti|56565656565656|111|2021|05|
|jyoti|bharani|testemail@nomail.com|9632144098|test|Select City|Maharashtra|2|jyoti|56565656565656|111|2021|05|
|jyoti|bharani|jyotibharani1@gmail.com|9632144098|test|Pune|Select State|2|jyoti|56565656565656|111|2021|05|
|jyoti|bharani|jyotibharani12@gmail.com|9632144098|test|Pune|Maharashtra|2||56565656565656|111|2021|05|
|jyoti|bharani|jyotibharani1@gmail.com|9632144098|test|Pune|Maharashtra|2|jyoti||111|2021|05|
|jyoti|bharani|jyotibharani1@gmail.com|9632144098|test|Pune|Maharashtra|2|jyoti|56565656565656||2021|05|
|jyoti|bharani|jyotibharani1@gmail.com|9632144098|test|Pune|Maharashtra|2|jyoti|56565656565656|111||05|
|jyoti|bharani|jyotibharani1@gmail.com|9632144098|test|Pune|Maharashtra|2|jyoti|56565656565656|111|2021||