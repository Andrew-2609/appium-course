package appium.page;

import appium.core.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FormPage extends BasePage {

    public void typeName(String name) {
        type(MobileBy.AccessibilityId("nome"), name);
    }

    public String getName() {
        return getText(MobileBy.AccessibilityId("nome"));
    }

    public void selectCombo(String value) {
        selectCombo(MobileBy.AccessibilityId("console"), value);
    }

    public String getComboValue() {
        return getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clickOnCheck() {
        click(By.className("android.widget.CheckBox"));
    }

    public void clickOnSwitch() {
        click(MobileBy.AccessibilityId("switch"));
    }

    public boolean isChecked() {
        return isChecked(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitched() {
        return isChecked(MobileBy.AccessibilityId("switch"));
    }

    public void save() {
        clickByText("SALVAR");
    }

    public String getRegisteredName() {
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String getRegisteredConsole() {
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    public String getRegisteredSwitch() {
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }

    public String getRegisteredCheckbox() {
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }
}
