package appium.test;

import appium.core.BaseTest;
import appium.page.FormPage;
import appium.page.MenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FormTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();

    private final FormPage formPage = new FormPage();

    @BeforeEach
    public void setUp() {
        menuPage.accessForm();
    }

    @Test
    @DisplayName("Must fill the Name text field in Form")
    public void mustFillNameTextFieldTest() {
        formPage.typeName("Andrew Monteiro");

        assertEquals("Andrew Monteiro", formPage.getName());
    }

    @Test
    @DisplayName("Must interact with Combo element")
    public void mustInteractWithComboTest() {
        formPage.selectCombo("Nintendo Switch");

        assertEquals("Nintendo Switch", formPage.getComboValue());
    }

    @Test
    @DisplayName("Must interact with Switch and Checkbox elements")
    public void mustInteractWithSwitchAndCheckboxTest() {
        assertFalse(formPage.isChecked());
        assertTrue(formPage.isSwitched());

        formPage.clickOnCheck();
        formPage.clickOnSwitch();

        assertTrue(formPage.isChecked());
        assertFalse(formPage.isSwitched());
    }

    @Test
    @DisplayName("Must perform the entire form registry")
    public void mustRegister() {
        formPage.typeName("Jogo");

        formPage.selectCombo("PS4");

        formPage.clickOnCheck();
        formPage.clickOnSwitch();

        formPage.save();

        assertEquals("Nome: Jogo", formPage.getRegisteredName());
        assertEquals("Console: ps4", formPage.getRegisteredConsole());
        assertTrue(formPage.getRegisteredSwitch().endsWith("Off"));
        assertTrue(formPage.getRegisteredCheckbox().endsWith("Marcado"));
    }
}
