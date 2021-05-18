package appium.test;

import appium.core.DSL;
import appium.core.DriverFactory;
import appium.page.FormPage;
import appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class FormTest {

    private final DSL dsl = new DSL();

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
        dsl.type(MobileBy.AccessibilityId("nome"), "Jogo");

        dsl.selectCombo(MobileBy.AccessibilityId("console"), "PS4");

        dsl.click(MobileBy.AccessibilityId("check"));
        dsl.click(MobileBy.AccessibilityId("switch"));

        dsl.clickByText("SALVAR");

        assertEquals("Nome: Jogo", dsl.getText(By.xpath("//android.widget.TextView[@text='Nome: Jogo']")));
        assertEquals("Console: ps4", dsl.getText(By.xpath("//android.widget.TextView[@text='Console: ps4']")));
        assertEquals("Switch: Off", dsl.getText(By.xpath("//android.widget.TextView[@text='Switch: Off']")));
        assertEquals("Checkbox: Marcado", dsl.getText(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']")));
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.kilLDriver();
    }
}
