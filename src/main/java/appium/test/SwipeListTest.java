package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.SwipeListPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appium.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwipeListTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();
    private final SwipeListPage swipeListPage = new SwipeListPage();

    @Test
    @DisplayName("Must successfully complete the SwipeList challenge")
    public void challengeSwipeList() {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

        menuPage.scrollDown();

        menuPage.accessSwipeList();

        swipeListPage.swipeFirstOptionLeft();

        swipeListPage.clickOnOptionPlusMinusText("Opção 1", "+");

        swipeListPage.swipeFourthOptionLeft();

        swipeListPage.clickOnOptionPlusMinusText("Opção 4", "-");

        swipeListPage.swipeFifthOptionRight();

        assertEquals("Opção 1 (+)", swipeListPage.getOptionText("Opção 1"));
        assertEquals("Opção 4 (-)", swipeListPage.getOptionText("Opção 4"));
        assertEquals("Opção 5", swipeListPage.getOptionText("Opção 5"));
    }
}
