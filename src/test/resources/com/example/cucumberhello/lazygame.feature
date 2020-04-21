Feature: Check if number is even or odd
  Background:
    Given I play this number game
    
  Scenario: playing for even number
    When the number is 4
    Then the result is "even"
  
  @SmokeTest  
  Scenario: playing for even number
    When the number is 5
    Then the result is "odd"
    
  Scenario Outline: Add two numbers <num1> & <num2>
    When I add <num1> and <num2>
    Then the result is <total>
    
  Examples: 
    | num1 | num2 | total |
    | -2 | 3 | 1 |
    | 10 | 15 | 25 |
    | 99 | -99 | 0 |
    | -1 | -10 | -11 |  