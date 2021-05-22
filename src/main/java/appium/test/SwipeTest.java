package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appium.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwipeTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();

    @Test
    @DisplayName("Must perform the swipe action")
    public void mustPerformSwipe() {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

        menuPage.scroll(0.9, 0.1);
        menuPage.accessSwipe();

        assertTrue(menuPage.elementExistsByText("a esquerda"));

        menuPage.swipe(0.9, 0.1);
        assertTrue(menuPage.elementExistsByText("você consegue"));

        menuPage.clickByText("›");
        assertTrue(menuPage.elementExistsByText("Chegar até o fim!"));

        menuPage.swipe(0.1, 0.9);
        assertTrue(menuPage.elementExistsByText("você consegue"));

        menuPage.clickByText("‹");
        assertTrue(menuPage.elementExistsByText("a esquerda"));
    }
}
