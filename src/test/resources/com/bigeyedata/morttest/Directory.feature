Feature: Create And Edit And Delete directory

  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangy@fullsample.com    | password123  |


  Scenario Outline: Create new directory
    Given I access to "<module>" module
    And I expand the DataSource directory
    When I want to create a new directory
    And I select the parent directory "根目录"
    And I input directory name is "测试第一级目录_1"
    When I save the new directory
    Then I should see the directory "测试第一级目录_1" displayed correctly in directory Container

    When I select favorite directory
    And I want to create a new directory
    And I select the parent directory "测试第一级目录_1"
    And I input directory name is "测试第二级目录_1"
    And I save the new directory
    Then I should see the directory "测试第二级目录_1" displayed correctly in directory Container

    When I select favorite directory
    And I want to create a new directory
    And I select the parent directory "测试第一级目录_1"
    And I input directory name is "测试第二级目录_2"
    And I save the new directory
    Then I should see the directory "测试第二级目录_2" displayed correctly in directory Container

    When I select favorite directory
    And I want to create a new directory
    And I select the parent directory "根目录"
    And I input directory name is "测试第一级目录_2"
    And I save the new directory
    Then I should see the directory "测试第一级目录_2" displayed correctly in directory Container
  Examples:
    | module     |
    | DataSource |
    | DataSet    |
    | Report     |
    | Dashboard  |


  Scenario: View the resources in the directory
    Given I access to "DataSource" module
    And I expand the DataSource directory
    When I select directory "测试第一级目录_1"
    And I create a HDFS DataSource with configuration as following
      | DataSourceName        | DataSourceType   | FileName       |
      | HDFS_parquet数据源_1    | Parquet           |bigeye_parquet |
    And I saved HDFS dataSource
    Then I should see the DataSource "HDFS_parquet数据源_1" displayed in directory

    When I select sub-directory "测试第二级目录_1"
    And I create a HDFS DataSource with configuration as following
      | DataSourceName       | DataSourceType   | FileName       |
      | HDFS_parquet数据源_2    | Parquet           |bigeye_parquet |
    And I saved HDFS dataSource
    Then I should see the DataSource "HDFS_parquet数据源_2" displayed in directory

    When I select sub-directory "测试第二级目录_2"
    And I create a HDFS DataSource with configuration as following
      | DataSourceName       | DataSourceType   | FileName       |
      | HDFS_parquet数据源_3    | Parquet           |bigeye_parquet |
    And I saved HDFS dataSource
    Then I should see the DataSource "HDFS_parquet数据源_3" displayed in directory

    When I select directory "测试第一级目录_2"
    And I create a HDFS DataSource with configuration as following
      | DataSourceName       | DataSourceType   | FileName       |
      | HDFS_parquet数据源_4    | Parquet           |bigeye_parquet |
    And I saved HDFS dataSource
    Then I should see the DataSource "HDFS_parquet数据源_4" displayed in directory

    When I select directory "测试第一级目录_1"
    Then I should see the DataSource "HDFS_parquet数据源_1" displayed in directory

    When I select sub-directory "测试第二级目录_1"
    Then I should see the DataSource "HDFS_parquet数据源_2" displayed in directory

    When I select sub-directory "测试第二级目录_2"
    Then I should see the DataSource "HDFS_parquet数据源_3" displayed in directory

    When I select directory "测试第一级目录_2"
    Then I should see the DataSource "HDFS_parquet数据源_4" displayed in directory


  Scenario Outline: Rename directory
    Given I access to "<module>" module
    And I expand the DataSource directory
    When I select directory "测试第一级目录_2"
    And I rename the directory name from "测试第一级目录_2" to "测试第一级目录2_重命名"
    Then I should see the directory "测试第一级目录2_重命名" displayed correctly in directory Container
  Examples:
    | module     |
    | DataSource |
    | DataSet    |
    | Report     |
    | Dashboard  |


  Scenario Outline: Delete empty directory
    Given I access to "<module>" module
    And I expand the DataSource directory
    When I want to create a new directory
    And I select the parent directory "根目录"
    And I input directory name is "测试目录_删除"
    And I save the new directory
    When I delete the directory "测试目录_删除"
    Then I should NOT see the directory "测试目录_删除" displayed in directory Container
  Examples:
      | module     |
      | DataSource |
      | DataSet    |
      | Report     |
      | Dashboard  |


  Scenario Outline: Delete directory with sub directory
    Given I access to "<module>" module
    And I expand the DataSource directory
    When I want to create a new directory
    And I select the parent directory "根目录"
    And I input directory name is "测试第一级目录_删除"
    And I save the new directory
    And I select favorite directory

    And I want to create a new directory
    And I select the parent directory "测试第一级目录_删除"
    And I input directory name is "测试第二级目录_删除"
    And I save the new directory

    And I select favorite directory
    And I delete the directory "测试第一级目录_删除"
    Then I should NOT see the directory "测试第一级目录_删除" displayed in directory Container
    And I should NOT see the directory "测试第二级目录_删除" displayed in directory Container
  Examples:
  | module     |
  | DataSource |
  | DataSet    |
  | Report     |
  | Dashboard  |


  Scenario: Delete datasource directory with resource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    When I want to create a new directory
    And I select the parent directory "根目录"
    And I input directory name is "测试目录_删除"
    And I save the new directory
    And I create a HDFS DataSource with configuration as following
      | DataSourceName       | DataSourceType   | FileName       |
      | HDFS_parquet数据源_5    | Parquet           |bigeye_parquet |
    And I saved HDFS dataSource
    And I delete the directory "测试目录_删除"
    Then I should see the notice message "目录不为空，无法删除"

    When I refresh current page
    And I access to "DataSource" module
    And I expand the DataSource directory
    And I select directory "测试目录_删除"
    And I delete the dataSource "HDFS_parquet数据源_5"
    And I delete the directory "测试目录_删除"
    Then I should NOT see the directory "测试目录_删除" displayed in directory Container










