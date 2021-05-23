package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appium.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WellHiddenOptionTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();

    @Test
    @DisplayName("Must find the well hidden option")
    public void mustFindTheWellHiddenOption() {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

        menuPage.scrollDown();

        menuPage.accessWellHiddenOption();

        assertEquals("Você achou essa opção", menuPage.getConfirmAlertMessage());

        menuPage.clickByText("OK");
    }
}
