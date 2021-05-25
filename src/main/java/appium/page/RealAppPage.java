package appium.page;

import appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import static appium.core.DriverFactory.getDriver;

public class RealAppPage extends BasePage {
    public void setName(String value) {
        getDriver().findElement(By.xpath("//*[@text='Nome']")).sendKeys(value);
    }

    public void setPassword(String value) {
        getDriver().findElement(By.xpath("//*[@text='Senha']")).sendKeys(value);
    }

    public void logIn() {
        clickByText("ENTRAR");
    }

    public void resetData() {
        clickByText("RESET");
    }

    public void changeToAccountsTab() {
        clickByText("CONTAS");
    }

    public void setAccountName(String value) {
        getDriver().findElement(By.xpath("//android.widget.EditText[@text='Conta']")).sendKeys(value);
    }

    public void saveAccount() {
        clickByText("SALVAR");
    }

    public void selectAccount(String accountName) {
        MobileElement element = getDriver().findElement(By.xpath("//*[@text='" + accountName + "']"));
        int xCenterOfScreen = getDriver().manage().window().getSize().width / 2;
        new TouchAction<>(getDriver()).longPress(PointOption.point(xCenterOfScreen, element.getCenter().y)).release().perform();
    }

    public void deleteAccount() {
        clickByText("EXCLUIR");
    }
}
