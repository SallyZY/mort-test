Feature:Create user,user group,role


  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangying@bigeyedata.com | password123  |

  Scenario: Check input box
    Given I access to "Management" module
    And I click create new user button on user page
    When I create the user
    Then I should see the prompt is "名称不能为空"
    And I input users basic information as following
      | UserName | Email                 | Phone      |
      |  test    |                       |            |
    When I create the user
    Then I should see the prompt is "邮箱不能为空"
    And I input users basic information as following
      | UserName                                                | Email                 | Phone      |
      |  123456789012345678901234567890123456789012345678901    |                       |            |
    When I create the user
    Then I should see the prompt is "名称长度应该小于等于50"
    And I input users basic information as following
      | UserName | Email                 | Phone      |
      |  test    | test                      |            |
    When I create the user
    Then I should see the prompt is "邮箱格式不合法"


  Scenario: Create a new user
    Given I access to "Management" module
    And I click create new user button on user page
    And I input users basic information as following
      | UserName | Email                 | Phone      |
      | test2    | email2@bigeyedata.com | 18292323923|
    And I set role is 管理员
    And I set group is group
    When I create the user
    Then I should see the Email is "email2@bigeyedata.com"



  Scenario: Search by user name OR email
    Given I access to "Management" module
    And I input user name is "test2" to searchInput
    When I click search button
    Then I should see the user name is "test2"
    And I input email is "email2@bigeyedata.com" to searchInput
    When I click search button
    Then I should see the Email is "email2@bigeyedata.com"


  Scenario: Modify password
    Given I access to "Management" module
    And I access to set password page of email is "email2@bigeyedata.com"
    And I set a new password "qwer1234"
    When I save the new password
    Then I should use the new password successful login  as following
      | UserName                 |  Password |
      | email2@bigeyedata.com    |  qwer1234 |



  Scenario: Edit a user information
    Given I access to "Management" module
    And I access to edit page of email is "email2@bigeyedata.com"
    And I modify the user basic information as following
      | UserName      | Email                       |
      | test2_rename  | email2_rename@bigeyedata.com|
    When I save the user
    Then I should see the email is "email2_rename@bigeyedata.com"


  Scenario: Check input box AND Create a new group AND Add user to group AND Delete user from group
    Given I access to "Management" module
    And I select group menuItem
    And I click create new group button on group page
    When I create the group
    Then I should see the prompt is "名称不能为空"
    And I input group name is "123456789012345678901234567890123456789012345678901"
    When I create the group
    Then I should see the prompt is "名称长度应该小于等于50"
    And I input group name is "测试用户组"
    When I create the group
    Then I should see the group name is "测试用户组"
    And I select group menuItem
    And I access to add user page of group name is "测试用户组"
    When I add user to group
    Then I should see the user displayed correctly
    And I select group menuItem
    And I access to add user page of group name is "测试用户组"
    When I Delete user from group
    Then I should see no data in the list



  Scenario: Search by group name
    Given I access to "Management" module
    And I select group menuItem
    And I input group name is "测试用户组" to searchInput
    When I click search button
    Then I should see the group name is "测试用户组"


  Scenario: Edit a group information
    Given I access to "Management" module
    And I select group menuItem
    And I access to edit page of group name is "测试用户组"
    And And I modify the group name to "测试用户组_重命名"
    When I save the group
    Then I should see the group name is "测试用户组_重命名"


  Scenario: Delete a group
    Given I access to "Management" module
    And I select group menuItem
    When I delete the group named "测试用户组_重命名"
    Then I shouldn't see the group name is "测试用户组_重命名"


  Scenario: Create a new role
    Given I access to "Management" module
    And I select role menuItem
    And I click create new role button on role page
    And I input role name is "测试角色"
    And I allocate all resource permissions
    When I create the role
    Then I should see the role name is "测试角色"


  Scenario: Edit a role information
    Given I access to "Management" module
    And I select role menuItem
    And I access to edit page of role name is "测试角色"
    And I modify the role name to "测试角色_重命名"
    When I save the role
    Then I should see the role name is "测试角色_重命名"


  Scenario: Delete a role
    Given I access to "Management" module
    And I select role menuItem
    When I delete the role named "测试角色_重命名"
    Then I shouldn't see the role name is "测试角色_重命名"

