package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WellHiddenOptionTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();

    @Test
    @DisplayName("Must find the well hidden option")
    public void mustFindTheWellHiddenOption() {
        menuPage.accessWellHiddenOption();

        assertEquals("Você achou essa opção", menuPage.getConfirmAlertMessage());

        menuPage.clickByText("OK");
    }
}
