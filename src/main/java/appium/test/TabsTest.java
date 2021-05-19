package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.TabsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TabsTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();

    private final TabsPage tabsPage = new TabsPage();

    @BeforeEach
    public void setUp() {
        menuPage.accessTabs();
    }

    @Test
    @DisplayName("Must interact with the Tabs")
    public void mustInteractWithTabs() {
        assertTrue(tabsPage.isOnFirstTab());

        tabsPage.selectSecondTab();

        assertTrue(tabsPage.isOnSecondTab());
    }
}
