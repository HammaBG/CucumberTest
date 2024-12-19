package StepDefinitions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {

    private ExtentReports extentReport = ExtentManager.getInstance();
    public static ExtentTest _scenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        TestBase.setUp();
        _scenario = extentReport.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = TestBase.captureScreenshot(scenario.getName());
            hooks._scenario.fail("Test Failed" , MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        extentReport.flush();   
        TestBase.teardown();
    }
}
