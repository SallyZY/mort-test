package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.pages.Page;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.bigeyedata.morttest.SeeThruUtils.currentPage;
import static com.bigeyedata.morttest.SeeThruUtils.onPage;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectoryStepdefs {

    @And("^I create new directory$")
    public void iCreateNewDirectory() throws Throwable {
         currentPage().dirPanel.createDirectory();
    }

    @And("^I select the parent directory \"([^\"]*)\"$")
    public void iSelectTheParentDirectory(String parentDirectory) throws Throwable {
        currentPage().dirPanel.selectRootDirectory(parentDirectory);
    }

    @And("^I input directory name is \"([^\"]*)\"$")
    public void iInputDirectoryNameIs(String directoryName) throws Throwable {
        currentPage().dirPanel.setDirectoryName(directoryName);
    }

    @When("^I save the new directory$")
    public void iSaveTheNewDirectory() throws Throwable {
        currentPage().dirPanel.saveDirectory();
    }

    @Then("^I should see the directory \"([^\"]*)\" displayed correctly in directory list$")
    public void iShouldSeeTheDirectoryDisplayedCorrectlyInDirectoryList(String directoryName) throws Throwable {
        assertThat(currentPage().dirPanel.getDirectory(directoryName),is(true));
    }


    @When("^I select DataSource multiLevelDirectory \"([^\"]*)\"$")
    public void iSelectDataSourceMultiLevelDirectory(String directoryName) throws Throwable {
        currentPage().dirPanel.clickMultiLevelDirectoryByName(directoryName);
    }

    @And("^I select DataSource subdirectories \"([^\"]*)\"$")
    public void iSelectDataSourceSubdirectories(String directoryName) throws Throwable {
        currentPage().dirPanel.clicsubDirectoryByName(directoryName);
    }

    @When("^I rename the directory name \"([^\"]*)\"$")
    public void iRenameTheDirectoryName(String directoryName) throws Throwable {
        currentPage().dirPanel.rename(directoryName);
    }


    @When("^I delete the directory name \"([^\"]*)\"$")
    public void iDeleteTheDirectoryName(String directoryName) throws Throwable {
        currentPage().dirPanel.openDropdownMenu(directoryName);
        currentPage().dirPanel.deleteDirectory();
    }

    @Then("^I should NOT see the directory \"([^\"]*)\" displayed in directory list$")
    public void iShouldNOTSeeTheDirectoryDisplayedInDirectoryList(String directoryName) throws Throwable {
        assertThat(currentPage().dirPanel.getDirectory(directoryName),is(false));
    }

    @And("^I go to rename of \"([^\"]*)\"$")
    public void iGoToRenameOf(String directoryName) throws Throwable {
        currentPage().dirPanel.openDropdownMenu(directoryName);
        currentPage().dirPanel.goToRnamePage();
    }
}
