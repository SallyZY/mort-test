Feature: Datasource

  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangying@bigeyedata.com | password123  |

  Scenario: Create a new RDB datasource
    Given I access to "datasource" module
    And I select datasource directory "测试数据源目录"
    And I want to create a RDB datasource with configuration as following
      | DatasourceType  | Host        | Port     | User      | Password  | Database         | DatasourceName  |
      | MySQL           |127.0.0.1    | 3306     | root      |           | customerdata_dev | 测试MySQL数据源  |
    When I click save button on RDB datasource configuration page
    Then I should see the created datasource "测试MySQL数据源" displayed in directory

  Scenario: Create a new File Datasource
    Given I access to "datasource" module
    And I select datasource directory "测试数据源目录"

  Scenario: Create a new HDFS datasource
    Given I access to "datasource" module
    And I select datasource directory "测试数据源目录"
    And I want to create a HDFS datasource with configuration as following
    | DatasourceName | Path                                 |
    |　测试HDFS数据源　|/home/u-123/bigeye/mort/parquet/aline|
    When I click save button on HDFS datasource configuration page
    Then I should see the created datasource "测试HDFS数据源" displayed in directory

