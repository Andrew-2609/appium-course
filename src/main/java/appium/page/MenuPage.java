package appium.page;

import appium.core.DSL;
import io.appium.java_client.MobileBy;

public class MenuPage {

    private final DSL dsl = new DSL();

    public void accessForm() {
        dsl.clickByText("Formulário");
    }

    public String getName() {
        return dsl.getText(MobileBy.AccessibilityId("nome"));
    }
}
