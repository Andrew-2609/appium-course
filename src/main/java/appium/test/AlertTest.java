package appium.test;

import appium.core.BaseTest;
import appium.page.AlertPage;
import appium.page.MenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AlertTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();

    private final AlertPage alertPage = new AlertPage();

    @BeforeEach
    public void setUp() {
        menuPage.accessAlert();
    }

    @Test
    @DisplayName("Must click on the outside of the Alert")
    public void mustClickOutsideAlert() {
        alertPage.clickOnSimpleAlert();

        waitFor(1000);

        alertPage.clickOutsideAlertBox();

        assertFalse(alertPage.elementExistsByText("Pode clicar no OK ou fora da caixa para sair"));
    }

    @Test
    @DisplayName("Must confirm the Alert message box")
    public void mustConfirmAlertMessageBox() {
        alertPage.clickOnConfirmAlert();

        assertEquals("Info", alertPage.getConfirmAlertTitle());
        assertEquals("Confirma a operação?", alertPage.getConfirmAlertMessage());

        alertPage.confirm();

        waitFor(1000);

        assertEquals("Confirmado", alertPage.getConfirmAlertMessage());

        alertPage.quit();
    }
}
