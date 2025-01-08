package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Pages.LoginPage;
import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends TestBase {
   private LoginPage loginPage;
   
   public LoginStep(){
      loginPage = new LoginPage(getDriver());
   }

    @When("the user enters a email as {string}")
    public void userEntersUsername(String email) {
        loginPage.enterEmail(email); 
    }

    @And("the user enters a password as {string}")
    public void userEntersPassword(String password) {
        loginPage.Enterpassword(password);
    }

    @And("clicks on the login button")
    public void userClicksLoginButton() {
        loginPage.submitLogin();
    }

    // @Then("the user should see a successful login message")
    // public void the_user_should_see_a_successful_login_message() {
    //   String msg= loginPage.SuccessMessage();
    //    assertTrue( msg.contains("You logged into a secure area!")); 
    // }

    // @Then("the user should see an error message")
    // public void the_user_should_see_an_error_message() {
    //     String msg = loginPage.FailedMessage();
    //     System.out.println("Captured error message: " + msg);
    //     assertTrue(msg.contains("Your username is invalid"), 
    //         "Expected error message to contain 'Your username is invalid', but got: " + msg);
    // }

    @Given("the user is on the login page")
    public void userIsOnLoginPage(){
        try{
            loginPage.openLoginPage();
            hooks._scenario.log(Status.PASS , "The user is on the login page ");
        } catch (Exception e){
            hooks._scenario.log(Status.FAIL,"Failed to open login page");
            throw e;
        }

    }

}
