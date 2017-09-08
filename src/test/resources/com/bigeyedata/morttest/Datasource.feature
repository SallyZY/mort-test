Feature: Create DataSource

  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangy@fullsample.com    | password123  |

  Scenario: Create a new RDB dataSource AND Edit RDB dataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource directory "测试数据源目录"
    And I want to create a RDB dataSource with configuration as following
      | DataSourceType  | Host        | Port     | User      | Password  | Database         | DataSourceName  |
      | MySQL           |127.0.0.1    | 1234     | haha      | 1234      | customerdata_dev | 测试MySQL数据源_test  |
    When I click save button on RDB dataSource configuration page
    Then I should see the DataSource "测试MySQL数据源_test" displayed in directory
    And I should see the DataSource configuration displayed correctly as following
      | DataSourceType  | Host        | Port     | User      | Database         |
      | mysql           |127.0.0.1    | 1234     | haha      | customerdata_dev |

    And I access to edit page of dataSourceName "测试MySQL数据源_test"
    And I want to modify RDB dataSource with configuration as following
      | Host        | Port     | User      | Password  |DataSourceName  |
      |localhost    | 3306     | root      |           |测试MySQL数据源  |
    When I click save button on RDB dataSource configuration page
    Then I should see the DataSource "测试MySQL数据源" displayed in directory
    And I should see the DataSource configuration displayed correctly as following
      | DataSourceType  | Host        | Port     | User      | Database         |
      | mysql           |localhost    | 3306     | root      | customerdata_dev |


  Scenario: Create a new HDFS dataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource directory "测试数据源目录"
    And I want to create a HDFS DataSource with configuration as following
      | DataSourceName       | DataSourceType   | Path                                                                          |
      | 测试HDFS_parquet数据源| Parquet           |src/test/resources/test-files/bigeye_parquet |
    When I click save button on HDFS dataSource configuration page
    Then I should see the DataSource "测试HDFS_parquet数据源" displayed in directory

    And I want to create a HDFS DataSource with configuration as following
      | DataSourceName   | DataSourceType   | Path                                                                          |
      | 测试HDFS_orc数据源| Orc              |/Users/liaoyuxue/Bigeye/mort-test/src/test/resources/test-files/airline-orc |
    When I click save button on HDFS dataSource configuration page
    Then I should see the DataSource "测试HDFS_orc数据源" displayed in directory


  Scenario: Create a new es dataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource directory "测试数据源目录"
    And I want to create a ES DataSource with configuration as following
      | DataSourceName  | Nodes         | Index         | Type                | Port  | Wan     |
      | 测试ES数据源      |192.168.0.180  | pa10million   | pa10million_type   |  9200  | true   |
    When I click save button on ES dataSource configuration page
    Then I should see the DataSource "测试ES数据源" displayed in directory
