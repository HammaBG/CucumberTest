package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver webdriver) {
        this.driver = webdriver;
    }

    public void openHomePage() {
        driver.get("http://localhost:5173/");  // Update this URL as per your environment
    }

    public void navigateToShopPage() {
        driver.findElement(By.xpath("//a[contains(@href,'/shop')]")).click(); // Update the XPath for the Shop link
    }
}
