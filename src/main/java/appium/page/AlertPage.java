package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {
    public void clickOnSimpleAlert() {
        clickByText("ALERTA SIMPLES");
    }

    public void clickOnConfirmAlert() {
        clickByText("ALERTA CONFIRM");
    }

    public String getConfirmAlertTitle() {
        return getText(By.id("android:id/alertTitle"));
    }

    public String getConfirmAlertMessage() {
        return getText(By.id("android:id/message"));
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
