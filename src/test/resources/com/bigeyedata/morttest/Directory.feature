Feature: Create And Edit And Delete directory

  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangy@fullsample.com    | password123  |


  Scenario:Create directory
    Given I access to "DataSource" module
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


  Scenario: View the resources in the directory
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource Multi-Level Directory "测试第一级目录1"
    And I create a HDFS DataSource with configuration as following
      | DataSourceName        | DataSourceType   | FileName       |
      | HDFS_parquet数据源1    | Parquet           |bigeye_parquet |
    And I saved HDFS dataSource
    And I should see the DataSource "HDFS_parquet数据源1" displayed in directory

    And I select DataSource subdirectories "测试第二级目录1"
    And I create a HDFS DataSource with configuration as following
      | DataSourceName       | DataSourceType   | FileName       |
      | HDFS_parquet数据源2    | Parquet           |bigeye_parquet |
    And I saved HDFS dataSource
    And I should see the DataSource "HDFS_parquet数据源2" displayed in directory

    And I select DataSource subdirectories "测试第二级目录2"
    And I create a HDFS DataSource with configuration as following
      | DataSourceName       | DataSourceType   | FileName       |
      | HDFS_parquet数据源3    | Parquet           |bigeye_parquet |
    And I saved HDFS dataSource
    And I should see the DataSource "HDFS_parquet数据源3" displayed in directory

    And I select DataSource directory "测试第一级目录2"
    And I create a HDFS DataSource with configuration as following
      | DataSourceName       | DataSourceType   | FileName       |
      | HDFS_parquet数据源4    | Parquet           |bigeye_parquet |
    And I saved HDFS dataSource
    And I should see the DataSource "HDFS_parquet数据源4" displayed in directory

    When I select DataSource Multi-Level Directory "测试第一级目录1"
    Then I should see the DataSource "HDFS_parquet数据源1" displayed in directory

    When I select DataSource subdirectories "测试第二级目录1"
    Then I should see the DataSource "HDFS_parquet数据源2" displayed in directory

    When I select DataSource subdirectories "测试第二级目录2"
    Then I should see the DataSource "HDFS_parquet数据源3" displayed in directory

    When I select DataSource directory "测试第一级目录2"
    Then I should see the DataSource "HDFS_parquet数据源4" displayed in directory


  Scenario: Rename directory
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource directory "测试第一级目录2"
    And I go to rename of "测试第一级目录2"
    When I rename the directory name "测试第一级目录2_ 重命名"
    Then I should see the directory "测试第一级目录2_ 重命名" displayed correctly in directory list


  Scenario: Delete directory
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I create new directory
    And I select the parent directory "根目录"
    And I input directory name is "测试目录_删除"
    And I save the new directory
    And I select DataSource directory "测试目录_删除"
    When I delete the directory name "测试目录_删除"
    Then I should NOT see the directory "测试目录_删除" displayed in directory list

    When I create new directory
    And I select the parent directory "根目录"
    And I input directory name is "测试目录_删除"
    And I save the new directory

    And I select DataSource directory "测试目录_删除"
    And I create a HDFS DataSource with configuration as following
      | DataSourceName       | DataSourceType   | FileName       |
      | HDFS_parquet数据源5    | Parquet           |bigeye_parquet |
    And I saved HDFS dataSource
    And I should see the DataSource "HDFS_parquet数据源5" displayed in directory

    And I delete the dataSource "HDFS_parquet数据源5"
    Then I shoud NOT see the DataSource "HDFS_parquet数据源4" displayed in directory

    And I select DataSource directory "测试目录_删除"
    And I delete the directory name "测试目录_删除"
    Then I should NOT see the directory "测试目录_删除" displayed in directory list

    When I create new directory
    And I select the parent directory "根目录"
    And I input directory name is "测试第一级目录_删除"
    And I save the new directory
    Then I should see the directory "测试第一级目录_删除" displayed correctly in directory list
    When I create new directory
    And I input directory name is "测试第二级目录_删除"
    And I save the new directory
    Then I should see the directory "测试第二级目录_删除" displayed correctly in directory list

    When I move the mouse to DataSource directory "测试第一级目录_删除"
    And I delete the multi-level directory name "测试第一级目录_删除"
    Then I should NOT see the directory "测试第一级目录_删除" displayed in directory list
    Then I should NOT see the directory "我的关注" displayed in resource list




