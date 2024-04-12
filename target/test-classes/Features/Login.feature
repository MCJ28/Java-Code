Feature: Login into the TutorialsNinja Application

@Dev
Scenario: User should Login into the Application with Valid Credentials
Given I Opened the TutorialsNinja Appliccation
And I Navigate to the Login Page
When User should enter the Email as "manojcj@gmail.com" and Password as "12345" into the fields
And User should click on the Login button
Then User should Login based on the credentials


