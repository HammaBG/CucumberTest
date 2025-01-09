package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {


    
    private WebDriver driver;
    private WebDriverWait wait;

   
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToLogoutPage() {
        driver.get("https://localhost:5173/logout");
    }

    public void submitLogout() {
        WebElement logoutElement = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("a.button.secondary.radius"))
        );
        logoutElement.click();
    }
    
    public String getSuccessMessage() {
        WebElement successMessageElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flash.success"))
        );
        return successMessageElement.getText();
    }

    public String getErrorMessage() {
        WebElement ErreurMessageElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flash.error"))
        );
        return ErreurMessageElement.getText();
    }
}
