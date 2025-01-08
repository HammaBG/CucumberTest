package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage {
     WebDriver driver; 
    private WebDriverWait wait ;

    public ShopPage(WebDriver webdriver) {
        this.driver = webdriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void openShopPage() {
        driver.get("http://localhost:5173/shop");
    }
    public void clickOnShopLink() {
        WebElement shopLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("shop")));
        shopLink.click();
    }
    public String getShopPageTitle() {
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shop")));  // Replace with actual locator
        return pageTitle.getText();
    }

    public void searchForProduct(String productName) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));  // Replace with actual locator for search box
        searchBox.sendKeys(productName);
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchButton")));  // Replace with actual locator for search button
        searchButton.click();
    }

    public void selectNecklaceCheckbox() {
        WebElement necklaceCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("pink-checkbox")));  // Replace with actual locator for the checkbox
        if (!necklaceCheckbox.isSelected()) {
            necklaceCheckbox.click();  // Select the checkbox if it's not already selected
        }
    }

    public String getSearchResultTitle() {
        WebElement resultTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTitle")));  // Replace with actual locator for the result title
        return resultTitle.getText();
    }
    
}
