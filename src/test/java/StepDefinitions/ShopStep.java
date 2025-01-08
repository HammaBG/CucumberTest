package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aventstack.extentreports.Status;
import Pages.HomePage;
import Pages.ShopPage;
import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class ShopStep extends TestBase {
    private HomePage homePage;
    private ShopPage shopPage;

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
}
