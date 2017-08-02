Feature: Create virtual dimension and virtual measure


  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangying@bigeyedata.com | password123  |

  Scenario: Create virtual dimension with text type
    Given I access to "DataSet" module
    And I expand the DataSet directory
    And I select DataSet as following
      |  DirectoryName  |  ResourceFileName |
      |  测试数据集目录   |  测试CSV数据集      |
    And I go to new report page from DataSet detail page
    When I want to create a new virtual dimension for DataSet "测试CSV数据集"
    And I set the name of virtual dimension is "VF_开户渠道"
    And I set the type of virtual dimension is "Text"
    And I set the expression of virtual dimension as following
      | Expression                                               |
      | if($[开户渠道].contains("测试")) "测试维度" else $[开户渠道] |
    And I validate the syntax of expression
    Then I should see the result of validation displayed

#    When I save the new virtual dimension
#    Then I should see the new virtual dimension "" displayed in DataSet field list