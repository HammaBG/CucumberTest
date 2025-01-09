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

    public ShopPage(WebDriver webdriver) {
        this.driver = webdriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
    }

    public void openShopPage() {
        driver.get("http://localhost:5173/shop"); 
    }

    public void selectNecklaceCheckbox() {
        WebElement necklaceCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//label[contains(text(),'NECKLACE')]/preceding-sibling::input[@type='checkbox']")
        ));
    
        if (!necklaceCheckbox.isSelected()) {
            necklaceCheckbox.click();
        }
    }

    public void clickHeartIconToAddToFavorites() {
        try {
            WebElement heartIcon = driver.findElement(By.cssSelector("div.absolute.top-2.right-5.cursor-pointer svg"));
            heartIcon.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click the heart icon: " + e.getMessage());
        }
    }


    public void openFavPage() {
        driver.get("http://localhost:5173/favorite");
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
