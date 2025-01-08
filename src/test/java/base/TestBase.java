package base;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
    private static WebDriver driver;
    private static WebDriverWait wait;
  

  @BeforeEach
  public static void setUp(){
       WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   }

   public static WebDriver getDriver() {
    return driver;
   }

   public static WebDriverWait getWait() {
    return wait;
   }
   @AfterEach
    public static void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
  public static String captureScreenshot(String scenarioName) {
        File screenshotDir = new File("target/screenshots/");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        try {
            TakesScreenshot screenshotTaker = (TakesScreenshot) driver;

            byte[] screenshotBytes = screenshotTaker.getScreenshotAs(OutputType.BYTES);

            String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());

            String screenshotName = scenarioName + "-" + timestamp + ".png";
            File screenshotFile = new File(screenshotDir, screenshotName);

            try (FileOutputStream fos = new FileOutputStream(screenshotFile)) {
                fos.write(screenshotBytes);
            }

            System.out.println("Screenshot saved at: " + screenshotFile.getAbsolutePath());

            return screenshotFile.getAbsolutePath();
        } catch (IOException e) {
            System.err.println("Error while saving screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }

        return "";
    }






}
