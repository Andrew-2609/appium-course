package appium.test;

import appium.core.BaseTest;
import appium.page.ClicksPage;
import appium.page.MenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClicksTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();
    private final ClicksPage clicksPage = new ClicksPage();

    @BeforeEach
    public void setUp() {
        menuPage.accessClicks();
    }

    @Test
    @DisplayName("Must perform a long click")
    public void mustPerformALongClick() {
        clicksPage.longClick();

        assertEquals("Clique Longo", clicksPage.getFieldText());
    }

    @Test
    @DisplayName("Must perform a double click")
    public void mustPerformADoubleClick() {
        clicksPage.doubleClick();

        assertEquals("Duplo Clique", clicksPage.getFieldText());
    }
}
