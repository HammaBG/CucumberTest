package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ShopPage {
    WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize the WebDriver and WebDriverWait
    public ShopPage(WebDriver webdriver) {
        this.driver = webdriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increased wait time
    }

    // Method to navigate to the shop page
    public void openShopPage() {
        driver.get("http://localhost:5173/shop");  // Ensure this URL is correct
    }

    // Method to select the NECKLACE checkbox
    public void selectNecklaceCheckbox() {
        // Wait for the checkbox to be present and clickable in the DOM
        WebElement necklaceCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//label[contains(text(),'NECKLACE')]/preceding-sibling::input[@type='checkbox']")
        ));
    
        // Click the checkbox if it's not already selected
        if (!necklaceCheckbox.isSelected()) {
            necklaceCheckbox.click();
        }
    }

    // Method to click the heart icon to add the necklace to favorites
    public void clickHeartIconToAddToFavorites() {
        try {
            // Locate the heart icon by the div's class
            WebElement heartIcon = driver.findElement(By.cssSelector("div.absolute.top-2.right-5.cursor-pointer svg"));
            // Click the heart icon
            heartIcon.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click the heart icon: " + e.getMessage());
        }
    }

    // Method to verify if the user is on the favorites page
    // public boolean isOnFavoritesPage() {
    //     String currentUrl = driver.getCurrentUrl();
    //     return currentUrl.equals("http://localhost:5173/favorite");
    // }

    public void openFavPage() {
        driver.get("http://localhost:5173/favorite");  // Ensure this URL is correct
    }
    public void clickOnFavoriteItem(String itemText) {
        try {
            WebElement favoriteItem = driver.findElement(By.xpath("//div[@class='text-lg' and text()='" + itemText + "']"));
            favoriteItem.click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Favorite item with text '" + itemText + "' not found", e);
        }
    }
    
}
