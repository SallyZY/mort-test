Feature: Create DataSource

  Background:
    Given I open browser and login to Mort Web
      | UserName              | Password     |
      | zhangy@fullsample.com | password123  |


  Scenario: Create a new RDB dataSource AND Edit RDB dataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource directory "测试数据源目录"
    And I create a RDB dataSource with configuration as following
      | DataSourceType  | Host        | Port     | User      | Password  | Database         | DataSourceName  |
      | MySQL           |127.0.0.1    | 1234     | haha      | 1234      | customerdata_dev | 测试MySQL数据源_test  |
    When I saved RDB dataSource
    Then I should see the DataSource "测试MySQL数据源_test" displayed in directory
    And I should see the DataSource configuration displayed correctly as following
      | DataSourceType  | Host        | Port     | User      | Database         |
      | mysql           |127.0.0.1    | 1234     | haha      | customerdata_dev |

    And I "edit" dataSource "测试MySQL数据源_test"
    And I modified RDB dataSource with configuration as following
      | Host        | Port     | User      | Password  |DataSourceName  |
      |localhost    | 3306     | root      |           |测试MySQL数据源  |
    When I saved RDB dataSource
    Then I should see the DataSource "测试MySQL数据源" displayed in directory
    And I should see the DataSource configuration displayed correctly as following
      | DataSourceType  | Host        | Port     | User      | Database         |
      | mysql           |localhost    | 3306     | root      | customerdata_dev |


  Scenario: Create a new HDFS dataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource directory "测试数据源目录"
    And I create a HDFS DataSource with configuration as following
      | DataSourceName       | DataSourceType   | FileName       |
      | 测试HDFS_parquet数据源| Parquet           |bigeye_parquet |
    When I saved HDFS dataSource
    Then I should see the DataSource "测试HDFS_parquet数据源" displayed in directory

    And I create a HDFS DataSource with configuration as following
      | DataSourceName   | DataSourceType   | FileName   |
      | 测试HDFS_orc数据源| Orc               |airline-orc |
    When I saved HDFS dataSource
    Then I should see the DataSource "测试HDFS_orc数据源" displayed in directory


  Scenario: Create a new ES dataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource directory "测试数据源目录"
    And I create a ES DataSource with configuration as following
      | DataSourceName  | Nodes         | Index         | Type                | Port  | Wan     |
      | 测试ES数据源      |192.168.0.180  | pa10million   | pa10million_type   |  9200  | true   |
    When I saved ES dataSource
    Then I should see the DataSource "测试ES数据源" displayed in directory


  Scenario: Delete dataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource directory "测试数据源目录"
    And I create a HDFS DataSource with configuration as following
      | DataSourceName       | DataSourceType   | FileName       |
      | 测试H数据源_Delete    | Parquet           |bigeye_parquet |
    And I saved HDFS dataSource
    And I should see the DataSource "测试H数据源_Delete" displayed in directory
    When I delete the dataSource "测试H数据源_Delete"
    Then I shoud NOT see the DataSource "测试H数据源_Delete" displayed in directory
