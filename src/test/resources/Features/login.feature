Feature: Login page automation of saucedemo app
Scenario: check login is successfull with valid cred
Given user is on login page
And enter valid username and password
And click on login Button
Then user is navigated to home screen
And close the browser