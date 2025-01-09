package StepDefinitions;

import Pages.LogoutPage;
import base.TestBase;


import org.junit.jupiter.api.Assertions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout_step {

     private LogoutPage logoutPage;

     public Logout_step() {
        
        this.logoutPage = new LogoutPage(TestBase.getDriver());
    }

    @Given("the user is on the logout page")
    public void userIsOnLogoutPage() {
        try {
            logoutPage.navigateToLogoutPage();
            hooks._scenario.log(Status.PASS, "The user is on the logout page");
        } catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "The user is not on the logout page");
            hooks._scenario.log(Status.FAIL, e.getMessage());
            throw e;
        }
    }

    @When("the user clicks on the logout button")
    public void userClicksLogoutButton() {
        try {
            logoutPage.submitLogout();
            hooks._scenario.log(Status.PASS, "The user clicks on the logout button");
        } catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "The user failed to click on the logout button");
            hooks._scenario.log(Status.FAIL, e.getMessage());
            throw e;
        }
    }

    @Then("the user should see a successful Logout message")
    public void userSeesSuccessfulLogoutMessage() {
        try {
            String logoutMessage = logoutPage.getSuccessMessage();
              Assertions.assertTrue(logoutMessage.contains("You logged out of the secure area!"),
                "Expected success message not found");
                hooks._scenario.log(Status.PASS, "The user sees the successful logout message: " + logoutMessage);
        } catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "The user does not see the successful logout message");
            hooks._scenario.log(Status.FAIL, e.getMessage());
            throw e;
        }
    }
    
}
