package appium.page.seuBarriga;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class SBHomePage extends BasePage {
    public String getBalanceFromAccount(String accountName) {
        return getText(By.xpath("//*[@text='" + accountName + "']/following-sibling::android.widget.TextView"));
    }

    public void updateHomeBalance() {
        scroll(0.2, 0.9);
    }
}
