package com.bigeyedata.morttest.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.bigeyedata.morttest.SeeThruUtils.currentPage;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectoryStepdefs {

    @And("^I want to create a new directory$")
    public void iCreateNewDirectory() throws Throwable {
        Thread.sleep(5000);
         currentPage().dirEditorPanel.createDir();
    }

    @And("^I select the parent directory \"([^\"]*)\"$")
    public void iSelectTheParentDirectory(String dirName) throws Throwable {
        currentPage().dirEditorPanel.selectParentDir(dirName);
    }

    @And("^I input directory name is \"([^\"]*)\"$")
    public void iInputDirectoryNameIs(String directoryName) throws Throwable {
        currentPage().dirEditorPanel.setDirName(directoryName);
    }

    @When("^I save the new directory$")
    public void iSaveTheNewDirectory() throws Throwable {
        currentPage().dirEditorPanel.confirmCreatDir();
    }

    @Then("^I should see the directory \"([^\"]*)\" displayed correctly in directory Container")
    public void iShouldSeeTheDirectoryDisplayedCorrectlyInDirectoryList(String directoryName) throws Throwable {
        Thread.sleep(2000);
        assertThat(currentPage().dirContainerPanel.isDirNameDisplayed(directoryName),is(true));
    }


    @When("^I select DataSource Multi-Level Directory \"([^\"]*)\"$")
    public void iSelectDataSourceMultiLevelDirectory(String directoryName) throws Throwable {
        currentPage().dirContainerPanel.clickMultiLevelDirectoryByName(directoryName);
    }

    @And("^I select DataSource subdirectories \"([^\"]*)\"$")
    public void iSelectDataSourceSubdirectories(String directoryName) throws Throwable {
        currentPage().dirContainerPanel.clicsubDirectoryByName(directoryName);
    }

    @When("^I rename the directory name \"([^\"]*)\"$")
    public void iRenameTheDirectoryName(String directoryName) throws Throwable {
        currentPage().dirContainerPanel.rename(directoryName);
    }


    @When("^I delete the directory name \"([^\"]*)\"$")
    public void iDeleteTheDirectoryName(String directoryName) throws Throwable {
        currentPage().dirContainerPanel.openDropdownMenu(directoryName);
        currentPage().dirContainerPanel.deleteDirectory();
    }

    @When("^I delete the multi-level directory name \"([^\"]*)\"$")
    public void iDeleteTheMultiLevelDirectoryName(String directoryName) throws Throwable {
        currentPage().dirContainerPanel.openMultiLevelDropdownMenu(directoryName);
        currentPage().dirContainerPanel.deleteDirectory();
    }

    @Then("^I should NOT see the directory \"([^\"]*)\" displayed in directory list$")
    public void iShouldNOTSeeTheDirectoryDisplayedInDirectoryList(String directoryName) throws Throwable {
        assertThat(currentPage().dirContainerPanel.isDirNameDisplayed(directoryName),is(false));
    }

    @And("^I go to rename of \"([^\"]*)\"$")
    public void iGoToRenameOf(String directoryName) throws Throwable {
        currentPage().dirContainerPanel.openDropdownMenu(directoryName);
        currentPage().dirContainerPanel.goToRnamePage();
    }

    @When("^I move the mouse to DataSource directory \"([^\"]*)\"$")
    public void iMoveTheMouseToDataSourceDirectory(String directoryName) throws Throwable {
        currentPage().dirContainerPanel.moveToDirectory(directoryName);
    }

    @Then("^I should NOT see the directory \"([^\"]*)\" displayed in resource list$")
    public void iShouldNOTSeeTheDirectoryDisplayedInResourceList(String directoryName) throws Throwable {
        assertThat(currentPage().dirContainerPanel.getDrectoryName().equals(directoryName),is(true));

    }

    @When("^I select favorite directory$")
    public void iSelectFavoriteDirectory() throws Throwable {
        currentPage().dirContainerPanel.clickFavoriteDir();
    }
}
