package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aventstack.extentreports.Status;
import Pages.ShopPage;
import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopNavigationSteps extends TestBase {
        private ShopPage shopPage;

        public ShopNavigationSteps() {
            shopPage = new ShopPage(getDriver());
        }

        @Given("the user is on the shop page")
        public void userIsOnShopPage() {
        try {
            shopPage.openShopPage();
            hooks._scenario.log(Status.PASS, "The user is on the shop page");
        } catch (Exception e) {
            hooks._scenario.log(Status.FAIL, "Failed to open shop page");
            throw e;
        }
        }
        @When("the user searches for a product {string}")
        public void userSearchesForProduct(String productName) {
        shopPage.searchForProduct(productName);
        }
        @And("the user selects the NECKLACE checkbox")
        public void userSelectsNecklaceCheckbox() {
        shopPage.selectNecklaceCheckbox();
        }
        @Then("the user should see search results for {string}")
        public void userShouldSeeSearchResults(String productName) {
        String resultTitle = shopPage.getSearchResultTitle();
        assertTrue(resultTitle.contains(productName), "Expected search result to contain the product name, but got: " + resultTitle);
        }

    
}
