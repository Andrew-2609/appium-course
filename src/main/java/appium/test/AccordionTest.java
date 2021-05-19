package appium.test;

import appium.core.BaseTest;
import appium.page.AccordionPage;
import appium.page.MenuPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccordionTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();

    private final AccordionPage accordionPage = new AccordionPage();

    @Test
    @DisplayName("Must interact with the accordion's option")
    public void mustInteractWithAccordion() {
        menuPage.accessAccordion();

        accordionPage.clickOnFirstOption();

        waitFor(1000);

        assertEquals("Esta é a descrição da opção 1", accordionPage.getFirstOptionText());
    }
}
