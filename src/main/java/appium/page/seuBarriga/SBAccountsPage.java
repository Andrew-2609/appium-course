package appium.page.seuBarriga;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class SBAccountsPage extends BasePage {
    public void setAccountName(String value) {
        type(By.xpath("//android.widget.EditText[@text='Conta']"), value);
    }

    public void saveAccount() {
        clickByText("SALVAR");
    }

    public void selectAccount(String accountName) {
        longClick(By.xpath("//android.widget.TextView[@text='" + accountName + "']"));
    }

    public void deleteAccount() {
        clickByText("EXCLUIR");
    }
}
