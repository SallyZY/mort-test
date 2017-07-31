Feature:Create user,user group,role


  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangying@bigeyedata.com | password123  |

  Scenario: Check validation message when create user with input is null or length over 50
    Given I access to "Management" module
    And I click create new user button on user page
    When I create the user
    Then I should see the prompt message is "名称不能为空"
    And I input users basic information as following
      | UserName | Email | Phone      |
      |  test    |       |            |
    When I create the user
    Then I should see the prompt message is "邮箱不能为空"
    And I input users basic information as following
      | UserName                                                | Email | Phone      |
      |  123456789012345678901234567890123456789012345678901    |       |            |
    When I create the user
    Then I should see the prompt message is "名称长度应该小于等于50"
    And I input users basic information as following
      | UserName | Email                 | Phone      |
      |  test    | test                  |            |
    When I create the user
    Then I should see the prompt message is "邮箱格式不合法"


  Scenario: Create a new Role, UserGroup and User
    Given I access to "Management" module
    And I select role menuItem
    And I click create new role button on role page
    And I input role name is "测试角色"
    And I grant all function permissions
    When I create the role
    Then I should see the role name is "测试角色"

    When I select group menuItem
    And I input group name is "测试用户组"
    And I create the group
    Then I should see the group name is "测试用户组"

    When I select user menuItem
    And I click create new user button on user page
    And I input users basic information as following
      | UserName | Email                 | Phone      |
      | test2    | email2@bigeyedata.com | 18292323923|
    And I set role is "测试角色"
    And I set group is "测试用户组"
    When I create the user
    Then I should see the Email is "email2@bigeyedata.com"

    When I input the keyword "test2" to user search box
    When I click search button
    Then I should see the user name "test2" in search result
    And I input the keyword "email2@bigeyedata.com" to user search box
    When I click search button
    Then I should see the Email "email2@bigeyedata.com" in search result


  Scenario: Edit a user information and password
    Given I access to "Management" module
    And I access to edit page of email "email2@bigeyedata.com"
    And I modify the user basic information as following
      | UserName      | Email                       |
      | test2_rename  | email2_rename@bigeyedata.com|
    When I save the user
    Then I should see the email is "email2_rename@bigeyedata.com"
    And I should see the user name "" in user list

    When I access to set password page of email is "email2@bigeyedata.com"
    And I set a new password "qwer1234"
    When I save the new password
    Then I should use the new password successful login  as following
      | UserName                 |  Password |
      | email2@bigeyedata.com    |  qwer1234 |


  Scenario: Check validation message when create user group
    Given I access to "Management" module
    And I select group menuItem
    And I click create new group button on group page
    When I create the group
    Then I should see the prompt message is "名称不能为空"
    And I input group name is "123456789012345678901234567890123456789012345678901"
    When I create the group
    Then I should see the prompt message is "名称长度应该小于等于50"


  Scenario: Create, edit and search user group

  Scenario: view and delete user group

#    And I input group name is "测试用户组"
#    When I create the group
#    Then I should see the group name is "测试用户组"
#    And I select group menuItem
#    And I access to add user page of group name is "测试用户组"
#    When I add user to group
#    Then I should see the user displayed correctly
#    And I select group menuItem
#    And I access to add user page of group name is "测试用户组"
#    When I Delete user from group
#    Then I should see no data in the list



  Scenario: Search by group name
    Given I access to "Management" module
    And I select group menuItem
    And I input group name is "测试用户组" to searchInput
    When I click search button
    Then I should see the group name is "测试用户组"


  Scenario: Edit a group information
    Given I access to "Management" module
    And I select group menuItem
    And I access to edit page of group name "测试用户组"
    And And I modify the group name to "测试用户组_重命名"
    When I save the group
    Then I should see the group name is "测试用户组_重命名"


  Scenario: Delete a group
    Given I access to "Management" module
    And I select group menuItem
    When I delete the group named "测试用户组_重命名"
    Then I shouldn't see the group name is "测试用户组_重命名"


  Scenario: Edit and delete a role
    Given I access to "Management" module
    And I select role menuItem
    And I click create new role button on role page
    And I input role name is "测试角色"
    And I grant all function permissions
    When I create the role
    Then I should see the role name is "测试角色"

    When I access to edit page of role name "测试角色"
    And I modify the role name to "测试角色_重命名"
    When I save the role
    Then I should see the role name is "测试角色_重命名"

    When I delete the role named "测试角色_重命名"
    Then I should NOT see the role name is "测试角色_重命名"

