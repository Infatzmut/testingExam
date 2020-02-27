package automation.steps;

import automation.AppTestRun;
import automation.pages.SelectFlyPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingSteps extends AppTestRun {

    @Given("^User is on home page$")
    public void userIsOnHomePage() throws Throwable {
        navigateTo("https://www.edestinos.com.pe/");
    }

    @When("^User selects an \"([^\"]*)\" and an \"([^\"]*)\"$")
    public void userSelectsAnOriginAndADestination(String origin, String destination) throws Throwable {
        bookingPage.chooseDestination(origin,destination);

    }

    @And("^User selects an exit_date and a return_date$")
    public void userSelectsAnExit_dateAndAReturn_date() throws Throwable {
        bookingPage.chooseDates("28", "29");
    }

    @And("^User clicks on search button$")
    public void userClicksOnSearchButton() throws Throwable {
        bookingPage.doSearch();
    }

    @Then("^User must see the available fligths$")
    public void userMustSeeTheAvailableFligths() throws Throwable {
        assert selectFlyPage.verifyFlightsAreDisplayed();
    }
}
