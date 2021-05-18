package appium.page;

import appium.core.DSL;

public class MenuPage {

    private final DSL dsl = new DSL();

    public void accessForm() {
        dsl.clickByText("Formulário");
    }
}
