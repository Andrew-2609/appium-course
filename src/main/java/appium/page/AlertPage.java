package appium.page;

import appium.core.BasePage;

public class AlertPage extends BasePage {
    public void clickOnSimpleAlert() {
        clickByText("ALERTA SIMPLES");
    }

    public void clickOnConfirmAlert() {
        clickByText("ALERTA CONFIRM");
    }

    public void confirm() {
        clickByText("CONFIRMAR");
    }

    public void quit() {
        clickByText("SAIR");
    }

    public void clickOutsideAlertBox() {
        tapOnCoordinates(100, 150);
    }
}
