package appium.core;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    @AfterEach
    public void tearDown(TestInfo testInfo) {
        generateScreenshot(testInfo.getDisplayName());
        DriverFactory.getDriver().resetApp();
    }

    @AfterAll
    static void finishClass() {
        DriverFactory.kilLDriver();
    }

    public void generateScreenshot(String methodDisplayName) {
        File screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("target/screenshots/" + methodDisplayName + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
