package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.WebViewPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebViewTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();
    private final WebViewPage webViewPage = new WebViewPage();

    @Test
    @DisplayName("Must login")
    public void mustLogin() {
        menuPage.accessHybridSB();

        waitFor(3000);

        webViewPage.enterWebContext();

        webViewPage.setEmail("mckg.minecraft@gmail.com");

        webViewPage.setPassword("myCucumberPassword");

        webViewPage.logIn();

        assertEquals("Bem vindo, Andrew Monteiro!", webViewPage.getSuccessMessage());
    }

    @AfterEach
    public void quitWebContext() {
        webViewPage.quitWebContext();
    }
}
