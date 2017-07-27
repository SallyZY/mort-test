Feature: Create DataSource

  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangying@bigeyedata.com | password123  |

  Scenario: Create a new RDB dataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource directory "测试数据源目录"
    And I want to create a RDB dataSource with configuration as following
      | DataSourceType  | Host        | Port     | User      | Password  | Database         | DataSourceName  |
      | MySQL           |127.0.0.1    | 3306     | root      |           | customerdata_dev | 测试MySQL数据源  |
    When I click save button on RDB dataSource configuration page
    Then I should see the DataSource "测试MySQL数据源" displayed in directory


  Scenario: Create a new HDFS dataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource directory "测试数据源目录"
    And I want to create a HDFS DataSource with configuration as following
    | DataSourceName | DataSourceType  | Path                                 |
    | 测试HDFS数据源　| Parquet         |/home/u-123/bigeye/mort/parquet/aline |
    When I click save button on HDFS dataSource configuration page
    Then I should see the DataSource "测试HDFS数据源" displayed in directory

