Feature: Login Functionality
@runValidLoginAsAdmin
Scenario Outline: Login with Valid Credentials
Given the user is on the login page
When the user enters a email as "<email>"
And the user enters a password as "<password>"
And clicks on the login button

Examples:
|email|password|
|mohamed@gmail.com|12345678|