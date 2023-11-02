Feature:Admin
@smoke
Scenario: Login with valid Credential
    Given User launch Chrome Browser
    When  User open url "https://admin-demo.nopcommerce.com/login"
    When  User enter emaail as "admin@yourstore.com" and password as "admin" 
    When  User click on Login button
    Then  Close browser
    
@sanity
Scenario Outline: Login Data driven
    Given User launch Chrome Browser
    When  User open url "https://admin-demo.nopcommerce.com/login"
    When   User enter emaail as "<email>" and password as "<password>" 
    When   User click on Login button
    Then  Close browser  
    Examples:
    |email                   |password   |
    |admin@yourstore.com     |admin      |
    |admin123@yourstore.com  |admin123   |
    