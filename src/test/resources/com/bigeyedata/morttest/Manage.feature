Feature:Create user,user group,role


  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangying@bigeyedata.com | password123  |

  Scenario: Create a new user
    Given I access to "Management" module
    And I click create new user button on user page
    And I input users basic information as following
      | UserName | Email               |
      | test2  | email2@bigeyedata.com|
    When I create the user
#    Then I should see the user displayed correctly

  Scenario: Create a new group
    Given I access to "Management" module
    And I select group menuItem
    And I click create new group button on group page
    And I input group name is "测试用户组"
    When I create the group
#    Then I should see the group displayed correctly

  Scenario: Rename a group
    Given
