package appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static AndroidDriver<MobileElement> driver;

    private static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/ndrewcoding/Desktop/Bagulos/Courses/Spring/appium-course/src/main/resources/012 CTAppium_1_2.apk");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        try {
            driver = new AndroidDriver<>(new URL(
                    "http://127.0.0.1:4723/wd/hub"), desiredCapabilities
            );
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void kilLDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
