package appium.page;

import appium.core.DSL;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FormPage {

    private final DSL dsl = new DSL();

    public void typeName(String name) {
        dsl.type(MobileBy.AccessibilityId("nome"), name);
    }

    public String getName() {
        return dsl.getText(MobileBy.AccessibilityId("nome"));
    }

    public void selectCombo(String value) {
        dsl.selectCombo(MobileBy.AccessibilityId("console"), value);
    }

    public String getComboValue() {
        return dsl.getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clickOnCheck() {
        dsl.click(By.className("android.widget.CheckBox"));
    }

    public void clickOnSwitch() {
        dsl.click(MobileBy.AccessibilityId("switch"));
    }

    public boolean isChecked() {
        return dsl.isChecked(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitched() {
        return dsl.isChecked(MobileBy.AccessibilityId("switch"));
    }

    public void save() {
        dsl.clickByText("SALVAR");
    }

    public String getRegisteredName() {
        return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String getRegisteredConsole() {
        return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    public String getRegisteredSwitch() {
        return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }

    public String getRegisteredCheckbox() {
        return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }
}
