#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Testing different actions on Amazon

Scenario: As a customer when I search for cap, I want to see my fav option  is available for purchase and can be added to the cart than can do a
succesfull checkout with COD.
Given The user navigate to www.amazon.com
When user enter valid username "7992216198"
And valid password "Tubai@1234" 
And User tries to search for a product	and click on search 
Then User will be navigate to the product page
And select the fav product from the user end and add to the cart
Then product should be added to cart
And user will do checkout process with COD
Then user will successfully checkout 
And logout and  close the browser

