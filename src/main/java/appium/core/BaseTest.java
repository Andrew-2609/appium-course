package appium.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {
    @AfterEach
    public void tearDown() {
        DriverFactory.getDriver().resetApp();
    }

    @AfterAll
    static void finishClass() {
        DriverFactory.kilLDriver();
    }
}
