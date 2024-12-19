package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {
    WebDriver driver; 
      private WebDriverWait wait ;

    public  LoginPage(WebDriver webdriver){
        this.driver=webdriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void openLoginPage(){
        
        driver.get("https://the-internet.herokuapp.com/login");
    }
    public void enterUsername(String username){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       WebElement usernameField= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys(username);
    }
    public void Enterpassword(String password){
        WebElement passwordfield= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordfield.sendKeys(password);
    }
    public void submitLogin(){
        WebElement loginBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginBtn.click();
    }
    public String SuccessMessage(){
        WebElement flash=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
       return flash.getText();
    }
    public String FailedMessage() {
        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        return flash.getText().trim(); // Trim to avoid unexpected whitespace
    }
}
