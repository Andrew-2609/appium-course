package appium.page;

import appium.core.DSL;
import io.appium.java_client.MobileBy;

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
}
