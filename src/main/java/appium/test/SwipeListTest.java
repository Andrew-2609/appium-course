package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.SwipeListPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwipeListTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();
    private final SwipeListPage swipeListPage = new SwipeListPage();

    @Test
    @DisplayName("Must successfully complete the SwipeList challenge")
    public void challengeSwipeList() {
        menuPage.accessSwipeList();

        swipeListPage.swipeOptionLeft("Opção 1");

        swipeListPage.clickOnOptionPlusMinusText("Opção 1", "+");

        swipeListPage.swipeOptionLeft("Opção 4");

        swipeListPage.clickOnOptionPlusMinusText("Opção 4", "-");

        swipeListPage.swipeOptionRight("Opção 5 (-)");

        assertEquals("Opção 1 (+)", swipeListPage.getOptionText("Opção 1"));
        assertEquals("Opção 4 (-)", swipeListPage.getOptionText("Opção 4"));
        assertEquals("Opção 5", swipeListPage.getOptionText("Opção 5"));
    }
}
