package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage {
    WebDriver driver;
    private WebDriverWait wait;

    public ShopPage(WebDriver webdriver) {
        this.driver = webdriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increased wait time
    }

    // public void openShopPage() {
    //     driver.get("http://localhost:5173/shop");  // Update to your actual URL
    // }

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
    
    
    
    
    
}
