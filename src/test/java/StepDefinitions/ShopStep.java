package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

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
        }
         catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "Failed to navigate to shop page");
            throw e;
        }
    }

    @And("the user selects the NECKLACE checkbox")
    public void userSelectsNecklaceCheckbox() {
        try {
            shopPage.selectNecklaceCheckbox();

            hooks._scenario.log(Status.PASS, "The user selects the NECKLACE checkbox");
        }
         catch (Exception e) {
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
        }
        catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "Failed to navigate to the favorites page");
            throw e;
        }
    }
    @And("the user clicks on a favorite item")
    public void theUserClicksOnAFavoriteItem() {
        try {
            WebElement favoriteItem = getDriver().findElement(By.xpath("//div[contains(text(), 'Necklace for men')]"));
            
            favoriteItem.click();
            
            hooks._scenario.log(Status.PASS, "The user clicked on the favorite item: Necklace for men");
        } catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "Failed to click on the favorite item");
            throw e;
        }
    }
    @Then("the user is navigated to the item's details page")
    public void theUserIsNavigatedToTheItemsDetailsPage() {
    try {
        String currentUrl = getDriver().getCurrentUrl();
        assertTrue(currentUrl.matches("http://localhost:5173/product/\\w+"), 
            "User is not navigated to the item's details page. Current URL: " + currentUrl);
        hooks._scenario.log(Status.PASS, "The user is successfully navigated to the item's details page: " + currentUrl);
    }
     catch (AssertionError | Exception e) {
        hooks._scenario.log(Status.FAIL, "Navigation to the item's details page failed");
        throw e;
    }
    }

    @Then("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonText) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='btn-container']//button[contains(text(), '" + buttonText + "')]")));
            
            button.click();
            
            hooks._scenario.log(Status.PASS, "The user clicked the \"" + buttonText + "\" button");
        } catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "Failed to click the \"" + buttonText + "\" button");
            throw e;
        }
    }
    

    @When("the user is navigated to the cart page")
    public void theUserIsNavigatedToTheCartPage() {
        try {
            String currentUrl = getDriver().getCurrentUrl();
            assertTrue(currentUrl.contains("/cart"), "The user was not navigated to the cart page!");
    
            hooks._scenario.log(Status.PASS, "The user is navigated to the cart page");
        }
       catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "Failed to navigate to the cart page");
            throw e;
        }
    }
    

    
    
}
