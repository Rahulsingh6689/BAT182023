Feature:Customer

Scenario Outline: Add New Customer
    Given User launch Chrome Browser
    When  User open url "https://admin-demo.nopcommerce.com/login"
    And   User enter emaail as "<email>" and password as "<password>" 
    And   User click on Login button
    Then  User can view Dashboard
    When  User click on customers menu
    And   User click on customers menu item
    And   User click on new add button
    Then  User can view add new customer page
    When  User enter customer info as "<newEmail>" and "<newPass>" and "<fname>" and "<lname>" and "<gender>" and "<comName>" and "<adminComment>"                   
    And   User click on save button
    Then  User can view customer info msg "The new customer has been added successfully"
    Then  Close browser  
    
    Examples:
    |email|password|newEmail|newPass|fname|lname|gender|comName|adminComment|
    |admin@yourstore.com|admin|raj11@gmail.com|1234|Bali17|Raj|Male|ABC|Test1|
    |admin@yourstore.com|admin|radhika12@gmail.com|4534|Radhika|Patel|Female|CDE|Test2|
    