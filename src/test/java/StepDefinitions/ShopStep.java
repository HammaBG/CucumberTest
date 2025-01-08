package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import Pages.HomePage;
import Pages.ShopPage;
import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopStep extends TestBase {
    private HomePage homePage;
    private ShopPage shopPage;
    private WebDriverWait wait;

    public ShopStep() {
        homePage = new HomePage(getDriver());
        shopPage = new ShopPage(getDriver());
    }

    @Given("the user is on the home page")
    public void userIsOnHomePage() {
        try {
            homePage.openHomePage();
            hooks._scenario.log(Status.PASS, "The user is on the home page");
        } catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "Failed to open home page");
            throw e;
        }
    }

    @And("the user navigates to the shop page")
    public void userNavigatesToShopPage() {
        try {
            homePage.navigateToShopPage();
            hooks._scenario.log(Status.PASS, "The user navigates to the shop page");
        } catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "Failed to navigate to shop page");
            throw e;
        }
    }

    @And("the user selects the NECKLACE checkbox")
    public void userSelectsNecklaceCheckbox() {
        try {
            shopPage.selectNecklaceCheckbox();
            hooks._scenario.log(Status.PASS, "The user selects the NECKLACE checkbox");
        } catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "Failed to select NECKLACE checkbox");
            throw e;
        }
    }
    @And("the user clicks on the heart icon to add the necklace to favorites")
    public void userClicksHeartIconToAddToFavorites() {
        try {
            shopPage.clickHeartIconToAddToFavorites();
            hooks._scenario.log(Status.PASS, "The user clicked the heart icon to add the necklace to favorites");
        } catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "Failed to click the heart icon");
            throw e;
        }
    }
    @Then("the user is navigated to the favorites page")
    public void userIsNavigatedToFavoritesPage() {
        try {
            shopPage.openFavPage();
            hooks._scenario.log(Status.PASS, "The user is on the favorites page");
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // Handle the InterruptedException if it's thrown during the sleep
            hooks._scenario.log(Status.FAIL, "Thread was interrupted while waiting");
            Thread.currentThread().interrupt(); // Restore the interrupted status
            throw new RuntimeException(e); 
        }catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "Failed to navigate to the favorites page");
            throw e;
        }
    }

    
    
}
