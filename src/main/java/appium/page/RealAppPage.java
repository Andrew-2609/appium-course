package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

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

    public void updateHomeBalance() {
        scroll(0.2, 0.9);
    }
}
