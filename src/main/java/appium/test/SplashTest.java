package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.SplashPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SplashTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();

    private final SplashPage splashPage = new SplashPage();

    @BeforeEach
    public void setUp() {
        menuPage.accessSplash();
    }

    @Test
    @DisplayName("Must wait for the Splash screen to disappear")
    public void mustWaitForTheSplashToDisappear() {
        assertTrue(splashPage.isSplashScreenVisible());

        splashPage.waitSplashScreenToDisappear();

        assertTrue(splashPage.elementExistsByText("Formulário"));
    }
}
