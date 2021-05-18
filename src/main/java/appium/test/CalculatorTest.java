package appium.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    @Test
    @DisplayName("Must sum two given values")
    public void mustSumTwoValues() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL(
                "http://127.0.0.1:4723/wd/hub"), desiredCapabilities
        );

        MobileElement digitTwo = driver.findElementById("com.android.calculator2:id/digit_2");

        digitTwo.click();

        MobileElement plusButton = driver.findElementByAccessibilityId("plus");

        plusButton.click();

        digitTwo.click();

        MobileElement resultElement = driver.findElementById("com.android.calculator2:id/result");

        Assertions.assertEquals("4", resultElement.getText());

        driver.quit();
    }
}
