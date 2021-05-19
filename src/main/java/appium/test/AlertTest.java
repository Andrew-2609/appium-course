package appium.test;

import appium.core.BaseTest;
import appium.page.AlertPage;
import appium.page.MenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();

    private final AlertPage alertPage = new AlertPage();

    @BeforeEach
    public void setUp() {
        menuPage.accessAlert();
    }

    @Test
    @DisplayName("Must confirm the Alert message box")
    public void mustConfirmAlertMessageBox() {
        alertPage.clickOnConfirmAlert();

        assertEquals("Info", alertPage.getConfirmAlertTitle());
        assertEquals("Confirma a operação?", alertPage.getConfirmAlertMessage());

        alertPage.confirm();

        assertEquals("Confirmado", alertPage.getConfirmAlertMessage());

        alertPage.quit();
    }
}
