package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

import static appium.core.DriverFactory.getDriver;

public class RealAppPage extends BasePage {
    public void setLoginName(String value) {
        type(By.xpath("//*[@text='Nome']"), value);
    }

    public void setLoginPassword(String value) {
        type(By.xpath("//*[@text='Senha']"), value);
    }

    public void login() {
        clickByText("ENTRAR");
    }

    public void resetData() {
        clickByText("RESET");
    }

    public void updateResume() {
        clickByText("ATUALIZAR");
    }

    public void swipeTransactionLeft(String transactionName) {
        int transactionYCoordinate = getDriver().findElement(By.xpath("//*[@text='" + transactionName + "']/../..")).getCenter().y;
        swipeAt(0.9, 0.1, transactionYCoordinate);
    }

    public void deleteTransaction() {
        clickByText("Del");
    }

    public void changeToHomeTab() {
        clickByText("HOME");
    }

    public void updateHomeBalance() {
        scroll(0.2, 0.9);
    }
}
