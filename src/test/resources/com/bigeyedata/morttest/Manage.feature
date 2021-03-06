Feature:Create user,user group,role


  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password    |
      | zhangy@fullsample.com   | password123  |


#  Scenario: Check validation message when create user with input is null
#    Given I access to "Management" module
#    And I click create new user button on user page
#    When I create the user
#    Then I should see the prompt message is "名称不能为空"
#    And I input users basic information as following
#      | UserName | Email | Phone      |
#      |  test    |       |            |
#    When I create the user
#    Then I should see the prompt message is "邮箱不能为空"


#  Scenario: Check validation message when create user with input length over 50
#    Given I access to "Management" module
#    And I click create new user button on user page
#    And I input users basic information as following
#      | UserName                                                | Email | Phone      |
#      |  123456789012345678901234567890123456789012345678901    |       |            |
#    When I create the user
#    Then I should see the prompt message is "名称长度应该小于等于50"
#    And I input users basic information as following
#      | UserName | Email                 | Phone      |
#      |  test    | test                  |            |
#    When I create the user
#    Then I should see the prompt message is "邮箱格式不合法"


  Scenario: Create a new Role, UserGroup and User
    Given I access to "Management" module

    And I select "Role" menuItem
    And I click create new role button on role page
    And I set role name is "测试角色_用户"
    And I grant all function permissions
    When I create the role
    Then I should see the role name is "测试角色_用户"

    When I select "UserGroup" menuItem
    And I click create new group button on group page
    And I set group name is "测试用户组_用户"
    And I create the group
    Then I should see the group name "测试用户组_用户" in group list

    When I select "User" menuItem
    And I click create new user button on user page
    And I input users basic information as following
      | UserName | Email                 | Phone      |
      | test     | email@bigeyedata.com  | 18292323923|
    And I set role is "测试角色_用户"
    And I set group is "测试用户组_用户"
    When I create the user
    Then I should see the email "email@bigeyedata.com" in user list

    When I search the user "test"
    Then I should see the user name "test" in search result
    When I search the email "email@bigeyedata.com"
    Then I should see the email "email@bigeyedata.com" in search result



  Scenario: Edit a user information and password
    Given I access to "Management" module
    And I "edit" user's email "email@bigeyedata.com"
    And I modify the user basic information as following
      | UserName      | Email                       | Phone      |
      | test_rename   | email_rename@bigeyedata.com | 18292323926|
    When I save the user
    Then I should see the email "email_rename@bigeyedata.com" in user list
    And I should see the user name "test_rename" in user list

    When I "modifyPassword" user's email "email_rename@bigeyedata.com"
    And I set a new password "qwer1234"
    And I save the new password
#    Then I should use the new password successful login as following
    Then I logout and login to Mort Web
      | UserName                       |  Password |
      | email_rename@bigeyedata.com    |  qwer1234 |


#  Scenario: Check validation message when create user group
#    Given I access to "Management" module
#    And I select group menuItem
#    And I click create new group button on group page
#    When I create the group
#    Then I should see the prompt message is "名称不能为空"
#    And I input group name is "123456789012345678901234567890123456789012345678901"
#    When I create the group
#    Then I should see the prompt message is "名称长度应该小于等于50"


  Scenario: Create, edit and search user group
    Given I access to "Management" module
    And I select "UserGroup" menuItem
    And I click create new group button on group page
    And I set group name is "测试用户组"
    When I create the group
    Then I should see the group name "测试用户组" in group list

    When I "edit" the group name "测试用户组"
    And  I modify the group name to "测试用户组_重命名"
    And I save the group
    Then I should see the group name "测试用户组_重命名" in group list

    When I search the group name "测试用户组_重命名"
    Then I should see the group name "测试用户组_重命名" in group list


  Scenario: view and delete user group
    Given I access to "Management" module
    And I select "UserGroup" menuItem
    And I "view" the group name "测试用户组_重命名"
    When I add users to group as following
      | UserName     | Email                      |
      | test_rename  | email_rename@bigeyedata.com|
    Then I should see users displayed correctly as following
      | Email                       |
      | email_rename@bigeyedata.com |

    When I "view" the group name "测试用户组_重命名"
    And I Delete users from group as following
      | Email                       |
      | email_rename@bigeyedata.com |
    Then I should see no data in the list

    When I "delete" the group name "测试用户组_重命名"
    Then I should NOT see the group name "测试用户组_重命名" in group list


  Scenario: Create and Edit and View and Delete a role
    Given I access to "Management" module
    And I select "Role" menuItem
    And I click create new role button on role page
    And I set role name is "测试角色"
    And I grant all function permissions
    When I create the role
    Then I should see the role name is "测试角色"

    When I "edit" the role name "测试角色"
    And I modify the role name to "测试角色_重命名"
    When I save the role
    Then I should see the role name is "测试角色_重命名"

    When I "view" the role name "测试角色_重命名"
    And I add users to role as following
      | UserName     | Email                      |
      | test_rename  | email_rename@bigeyedata.com|
    Then I should see users displayed correctly as following
      | Email                       |
      | email_rename@bigeyedata.com |

    When I "view" the role name "测试角色_重命名"
    And I Delete users from role as following
      | Email                       |
      | email_rename@bigeyedata.com |
    Then I should see no data in the list

    When I "delete" the role name "测试角色_重命名"
    Then I should NOT see the role name is "测试角色_重命名"

