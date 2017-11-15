Feature: Verify detail of union DataSet

  Background:
    Given I open browser and login to Mort Web
      | UserName              | Password     |
      | zhangy@fullsample.com | password123  |


  Scenario: Verify the result of union dataset
    Given I access to "DataSet" module
    And I expand the DataSource directory
    And I select DataSet as following
      |  DirectoryName   |  ResourceFileName |
      |  测试关联数据集目录 |  三表关联-导入      |